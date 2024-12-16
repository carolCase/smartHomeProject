package com.carolCase.settings_project_fullstack.controller

import com.carolCase.settings_project_fullstack.model.CustomUser
import com.carolCase.settings_project_fullstack.repository.CustomUserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping

import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("/users")
class CustomUserController @Autowired constructor(val customUserRepository: CustomUserRepository){

    @PostMapping
    fun saveUser(@RequestBody newUser: CustomUser): ResponseEntity<Map<String, String>> {
        customUserRepository.save(newUser)
        val response = mapOf("message" to "User saved successfully")
        return ResponseEntity.ok(response)
    }


     @GetMapping
     fun getAllCustomUsers(): ResponseEntity<List<CustomUser>>{

         val users: List<CustomUser> = customUserRepository.findAll()
         return ResponseEntity.ok(users)
     }



}