package com.carolCase.settings_project_fullstack.controller

import com.carolCase.settings_project_fullstack.model.CustomUser
import com.carolCase.settings_project_fullstack.model.authority.UserRole
import com.carolCase.settings_project_fullstack.repository.CustomUserRepository
import jakarta.validation.Valid
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.web.bind.annotation.*
import org.springframework.web.server.ResponseStatusException

@RestController
@RequestMapping("/users")

class CustomUserController @Autowired constructor(
    val customUserRepository: CustomUserRepository,
    val passwordEncoder: PasswordEncoder
) {

    @PostMapping("/register")
    fun saveUser(@Valid @RequestBody newUser: CustomUser): ResponseEntity<Map<String, String>> {
        // Check if the username already exists
        if (customUserRepository.existsByUserName(newUser.userName)) {
            return ResponseEntity.badRequest().body(mapOf("error" to "Username already exists"))
        }

        // Handle empty or invalid UserRole
        val role = try {
            if (newUser.role.name.isBlank()) UserRole.USER else UserRole.valueOf(newUser.role.name.uppercase())
        } catch (e: IllegalArgumentException) {
            UserRole.USER
        }

        // Create the user with all fields
        val bcryptUser = CustomUser(
            userName = newUser.userName,
            password = passwordEncoder.encode(newUser.password),  // Password encoded here
            role = role
        )

        // Save the user
        customUserRepository.save(bcryptUser)

        // Return success response
        return ResponseEntity.ok(mapOf("message" to "User saved successfully"))
    }



    @GetMapping
    fun getAllCustomUsers(): ResponseEntity<List<CustomUser>> {
        val users = customUserRepository.findAll()
        return ResponseEntity.ok(users)
    }

    @PatchMapping("/{id}")
    fun updateAdminStatus(@PathVariable("id") id: Long, @RequestBody updatedFields: Map<String, Any>): ResponseEntity<CustomUser> {
        val existingUser = customUserRepository.findById(id)
            .orElseThrow { ResponseStatusException(HttpStatus.NOT_FOUND, "User not found with ID: $id") }

       // val isAdmin = updatedFields["isAdmin"] as? Boolean ?: existingUser.isAdmin
      //  val updatedUser = existingUser.copy(isAdmin = isAdmin)

        return ResponseEntity.ok(customUserRepository.save(existingUser))
    }

    @DeleteMapping("/{id}")
    fun deleteUser(@PathVariable("id") id: Long): ResponseEntity<Map<String, String>> {
        val existingUser = customUserRepository.findById(id)
            .orElseThrow { ResponseStatusException(HttpStatus.NOT_FOUND, "User not found with ID: $id") }

        customUserRepository.delete(existingUser)
        return ResponseEntity.ok(mapOf("message" to "User with ID $id successfully deleted"))
    }
}
