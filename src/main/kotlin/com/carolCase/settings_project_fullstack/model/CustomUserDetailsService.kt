package com.carolCase.settings_project_fullstack.model

import com.carolCase.settings_project_fullstack.repository.CustomUserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.stereotype.Service
import java.lang.NullPointerException


@Service
class CustomUserDetailsService(
    @Autowired val customUserRepository: CustomUserRepository
) : UserDetailsService {

    override fun loadUserByUsername(username: String?): UserDetails {
        if (username == null) {
            throw NullPointerException("Username is null")
        }
        println("Looking for user: $username")
        // Query the database and handle nullable result
        val user = customUserRepository.findByUserName(username)
            ?: throw UsernameNotFoundException("Username '$username' wasn't found")

        println("Username was found!")

        return CustomUserDetails(
            user.userName,
            user.password,
            user.role
        )
    }
}


