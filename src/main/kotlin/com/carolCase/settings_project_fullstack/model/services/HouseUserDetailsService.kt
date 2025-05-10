package com.carolCase.settings_project_fullstack.model.services
import com.carolCase.settings_project_fullstack.model.HouseUserDetails


import com.carolCase.settings_project_fullstack.repository.HouseUserRepository
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.stereotype.Service

@Service
class HouseUserDetailsService(
    private val houseUserRepository: HouseUserRepository
) : UserDetailsService {

    override fun loadUserByUsername(email: String): UserDetails {
        val user = houseUserRepository.findByEmail(email)
            ?: throw UsernameNotFoundException("User not found with email: $email")

        return HouseUserDetails(user)
    }
}
