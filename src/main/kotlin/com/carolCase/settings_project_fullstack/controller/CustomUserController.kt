package com.carolCase.settings_project_fullstack.controller

import com.carolCase.settings_project_fullstack.model.CustomUser
import com.carolCase.settings_project_fullstack.repository.CustomUserRepository
import jakarta.validation.Valid
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.web.bind.annotation.DeleteMapping

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PatchMapping
import org.springframework.web.bind.annotation.PathVariable

import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.server.ResponseStatusException


@RestController
@RequestMapping("/users")
class CustomUserController @Autowired constructor
    (val customUserRepository: CustomUserRepository,
     val passwordEncoder: PasswordEncoder)
{

    @PostMapping
    fun saveUser( @Valid @RequestBody newUser: CustomUser): ResponseEntity<Map<String, String>>
    {
        if (customUserRepository.existsByUserName(newUser.userName)) {
            val response = mapOf("error" to "Username already exists")
            return ResponseEntity.badRequest().body(response)
        }
        val bcryptUser = CustomUser(
            newUser.userName,
            passwordEncoder.encode(newUser.password)
        )
        customUserRepository.save(bcryptUser)

        val response = mapOf("message" to "User saved successfully")
        return ResponseEntity.ok(response)

    }

    @GetMapping("/im-i-logged-in")
    fun checkIfLoggedIn(): ResponseEntity<String>{
        return ResponseEntity.ok("You are logged in")
    }







    @GetMapping
    fun getAllCustomUsers(): ResponseEntity<List<CustomUser>> {
        val users: List<CustomUser> = customUserRepository.findAll()
        return ResponseEntity.ok(users)
    }

    @PatchMapping("/{id}")
    fun updateAdminStatus(@PathVariable("id") id: Long, @RequestBody updatedFields: Map<String, Any>): CustomUser {
        val existingUser = customUserRepository.findById(id)
            .orElseThrow { ResponseStatusException(HttpStatus.NOT_FOUND, "User not found with id: $id") }

        val isAdmin = updatedFields["isAdmin"] as? Boolean ?: existingUser.isAdmin

        val updatedUser = existingUser.copy(isAdmin = isAdmin)

        return customUserRepository.save(updatedUser)
    }


    @DeleteMapping("/{id}")
fun deleteUser(@PathVariable("id") id: Long): String {
val existingUser = customUserRepository.findById(id)
    .orElseThrow{ResponseStatusException(HttpStatus.NOT_FOUND, "user with id: $id not found")}
        customUserRepository.delete(existingUser)
        return "user with $id successfully deleted"
    }





}











