package com.carolCase.settings_project_fullstack.controller

import com.carolCase.settings_project_fullstack.model.CustomUser
import com.carolCase.settings_project_fullstack.repository.CustomUserRepository
import jakarta.validation.Valid
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.security.crypto.password.PasswordEncoder

import org.springframework.web.bind.annotation.GetMapping

import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("/users")
class CustomUserController @Autowired constructor
    (val customUserRepository: CustomUserRepository,
     val passwordEncoder: PasswordEncoder)
{

    @PostMapping
    fun saveUser( @Valid @RequestBody newUser: CustomUser): ResponseEntity<Map<String, String>>
    {
        if (customUserRepository.existsByUsername(newUser.name)) {
            val response = mapOf("error" to "Username already exists")
            return ResponseEntity.badRequest().body(response)
        }
        val bcryptUser = CustomUser(
            newUser.name,
            passwordEncoder.encode(newUser.password)
        )
        customUserRepository.save(bcryptUser)

        val response = mapOf("message" to "User saved successfully")
        return ResponseEntity.ok(response)

    }


    @GetMapping
    fun getAllCustomUsers(): ResponseEntity<List<CustomUser>> {
        val users: List<CustomUser> = customUserRepository.findAll()
        return ResponseEntity.ok(users)
    }





}