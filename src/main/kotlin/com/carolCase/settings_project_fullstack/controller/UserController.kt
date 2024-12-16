package com.carolCase.settings_project_fullstack.controller

import com.carolCase.settings_project_fullstack.model.CustomUser
import com.carolCase.settings_project_fullstack.repository.CustomUserRepository
import org.springframework.beans.factory.annotation.Autowired

import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("/user")
class UserController (@Autowired val customUserRepository: CustomUserRepository) {

    @PostMapping
    fun saveUser(@RequestBody customUser: CustomUser): CustomUser {
        customUserRepository.save(customUser)
        return customUser

    }




}