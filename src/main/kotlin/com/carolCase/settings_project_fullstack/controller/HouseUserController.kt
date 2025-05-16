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




}
