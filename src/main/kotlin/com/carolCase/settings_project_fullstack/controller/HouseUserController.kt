package com.carolCase.settings_project_fullstack.controller

import com.carolCase.settings_project_fullstack.model.HouseUser
import com.carolCase.settings_project_fullstack.model.HouseUserDetails
import com.carolCase.settings_project_fullstack.repository.HouseUserRepository
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.security.access.prepost.PreAuthorize
import org.springframework.security.core.context.SecurityContextHolder

@RestController
@RequestMapping("/users")
class HouseUserController<HttpServletRequest>(
    private val houseUserRepository: HouseUserRepository
) {

    @GetMapping
    fun getAllUsers(): List<HouseUser> {
        val users = houseUserRepository.findAll()
        println("Fetched users: $users")
        return users
    }


    @GetMapping("/admin-only")
    @PreAuthorize("hasRole('OWNER')")
    fun adminEndpoint(): String = "Only OWNERs can see this"

    @GetMapping("/who-am-i")
    fun checkedLoggedInUser(request: HttpServletRequest): ResponseEntity<Any> {
        val auth = SecurityContextHolder.getContext().authentication

        if (auth != null && auth.isAuthenticated && auth.principal is HouseUserDetails) {
            val userDetails = auth.principal as HouseUserDetails
            val houseUser = houseUserRepository.findByEmail(userDetails.username)

            return if (houseUser != null) {
                ResponseEntity.ok(
                    mapOf(
                        "email" to houseUser.email,
                        "fullName" to houseUser.fullName,
                        "role" to houseUser.role
                    )
                )
            } else {
                ResponseEntity.status(404).body("User not found")
            }
        }

        return ResponseEntity.status(401).body("Not authenticated")
    }


}
