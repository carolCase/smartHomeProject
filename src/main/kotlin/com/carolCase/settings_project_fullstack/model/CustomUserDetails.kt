package com.carolCase.settings_project_fullstack.model

import com.carolCase.settings_project_fullstack.model.authority.UserRole
import org.springframework.security.core.userdetails.UserDetails

class CustomUserDetails(
    private val username: String,
    private val password: String,
    private val role: UserRole
) : UserDetails {

    override fun getAuthorities() = role.getAuthorities()
    override fun getPassword() = password
    override fun getUsername() = username

    override fun isAccountNonExpired() = true
    override fun isAccountNonLocked() = true
    override fun isCredentialsNonExpired() = true
    override fun isEnabled() = true
}


