
package com.carolCase.settings_project_fullstack.model

import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.userdetails.UserDetails

class HouseUserDetails(
    private val user: HouseUser
) : UserDetails {



    override fun getUsername(): String = user.email

    override fun getPassword(): String = user.passwordHash

    override fun getAuthorities(): Collection<GrantedAuthority> =
        listOf(SimpleGrantedAuthority("ROLE_${user.role.name}"))

    override fun isAccountNonExpired(): Boolean = true
    override fun isAccountNonLocked(): Boolean = true
    override fun isCredentialsNonExpired(): Boolean = true
    override fun isEnabled(): Boolean = true

    fun getFullName(): String? = user.fullName
    fun getUserId(): Long = user.id
}
