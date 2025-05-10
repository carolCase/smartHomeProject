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
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.authentication.BadCredentialsException
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.Authentication
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.web.bind.annotation.*
import java.util.concurrent.TimeUnit

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
    fun checkedLoggedInUser(request: HttpServletRequest): ResponseEntity<String> {
        val auth = SecurityContextHolder.getContext().authentication

        return if (auth != null && auth.isAuthenticated) {
            val username = auth.name
            val roles = auth.authorities.joinToString(",") { it.authority }
            ResponseEntity.ok("Logged in as: $username ($roles)")
        } else {
            ResponseEntity.status(401).body("User is not authenticated")
        }
    }

    @PostMapping("/register")
    fun registerUser(
        @RequestBody @Valid request: RegisterRequest
    ): ResponseEntity<String> {
        if (houseUserRepository.findByEmail(request.email) != null) {
            return ResponseEntity.status(409).body("Email already registered")
        }

        val newUser = HouseUser(
            email = request.email,
            passwordHash = passwordEncoder.encode(request.password),
            fullName = request.fullName,
            role = Role.MEMBER
        )

        houseUserRepository.save(newUser)

        return ResponseEntity.status(201).body("User registered successfully")
    }

}
