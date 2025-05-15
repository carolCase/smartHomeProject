package com.carolCase.settings_project_fullstack.controller

import com.carolCase.settings_project_fullstack.model.HouseUser
import com.carolCase.settings_project_fullstack.model.Role
import com.carolCase.settings_project_fullstack.model.dto.RegisterRequest
import com.carolCase.settings_project_fullstack.repository.HouseUserRepository
import jakarta.validation.Valid
import org.springframework.security.crypto.password.PasswordEncoder

import com.carolCase.settings_project_fullstack.config.jwt.JwtUtil
import com.carolCase.settings_project_fullstack.model.HouseUserDetails
import jakarta.servlet.http.Cookie
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.security.access.prepost.PreAuthorize
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.authentication.BadCredentialsException
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.Authentication
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.web.bind.annotation.*
import java.util.concurrent.TimeUnit
import com.carolCase.settings_project_fullstack.model.dto.RoleRequest

@RestController
class AuthenticationController @Autowired constructor(
    private val authenticationManager: AuthenticationManager,
    private val jwtUtil: JwtUtil,
    private val houseUserRepository: HouseUserRepository,
    private val passwordEncoder: PasswordEncoder



) {


    @PostMapping("/login")
    fun authenticateUser(
        @RequestParam username: String?,
        @RequestParam password: String?,
        response: HttpServletResponse
    ): ResponseEntity<String> {
        if (username.isNullOrBlank() || password.isNullOrBlank()) {
            return ResponseEntity.badRequest().body("Username and password are required")
        }
        val user = houseUserRepository.findByEmail(username!!)
        if (user == null) {
            println("❌ User not found: $username")
        } else {
            println("✅ Found user: ${user.email}")
            println("🧩 Password matches: ${passwordEncoder.matches(password, user.passwordHash)}")
        }

        return try {
            val authToken = UsernamePasswordAuthenticationToken(username, password)
            val authentication: Authentication = authenticationManager.authenticate(authToken)

            val principal = authentication.principal
            if (principal !is HouseUserDetails) {
                return ResponseEntity.internalServerError()
                    .body("Authenticated principal is not of type HouseUserDetails")
            }

            val token = jwtUtil.generateJwtToken(
                principal.username,
                principal.authorities.joinToString(",") { it.authority }
            )

            val cookie = Cookie("authToken", token).apply {
                isHttpOnly = true
                secure = false
                path = "/"
                maxAge = TimeUnit.HOURS.toSeconds(1).toInt()
            }

            response.addCookie(cookie)

            ResponseEntity.ok(token)

        } catch (e: BadCredentialsException) {
            ResponseEntity.status(401).body("Bad credentials")
        }
    }

    @GetMapping("/who-am-i")
    fun checkedLoggedInUser(): ResponseEntity<Any> {
        val auth = SecurityContextHolder.getContext().authentication

        return if (auth != null && auth.isAuthenticated && auth.principal is HouseUserDetails) {
            val user = auth.principal as HouseUserDetails

            val responseBody = mapOf(
                "email" to user.username,
                "fullName" to user.getFullName(),
                "role" to user.authorities.joinToString(",") { it.authority.replace("ROLE_", "") }
            )

            ResponseEntity.ok(responseBody)
        } else {
            ResponseEntity.status(401).body(mapOf("error" to "User is not authenticated"))
        }
    }


    @PostMapping("/register")
    fun registerUser(
        @RequestBody @Valid request: RegisterRequest
    ): ResponseEntity<String> {
        println("📩 RECEIVED REGISTER REQUEST: $request")
        if (houseUserRepository.findByEmail(request.email) != null) {
            return ResponseEntity.status(409).body("Email already registered")
        }

        val isFirstUser = houseUserRepository.count().toInt() == 0
        val newUser = HouseUser(
            email = request.email,
            passwordHash = passwordEncoder.encode(request.password),
            fullName = request.fullName,
            role = if (isFirstUser) Role.OWNER else Role.GUEST
        )

        houseUserRepository.save(newUser)

        return ResponseEntity.status(201).body("User registered successfully")
    }
    @PatchMapping("/users/{id}/role")
    @PreAuthorize("hasRole('OWNER')")
    fun changeUserRole(
        @PathVariable id: Long,
        @RequestBody roleRequest: RoleRequest
    ): ResponseEntity<String> {
        val user = houseUserRepository.findById(id).orElse(null)
            ?: return ResponseEntity.notFound().build()

        user.role = roleRequest.role
        houseUserRepository.save(user)
        return ResponseEntity.ok("Role updated to ${roleRequest.role}")
    }




}
