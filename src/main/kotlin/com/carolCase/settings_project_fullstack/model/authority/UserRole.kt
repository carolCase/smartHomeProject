package com.carolCase.settings_project_fullstack.model.authority
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.authority.SimpleGrantedAuthority

enum class UserRole(private val permissions: List<UserPermission>) {
    USER(listOf(UserPermission.READ)),
    ADMIN(listOf(
        UserPermission.READ,
        UserPermission.WRITE,
        UserPermission.UPDATE,
        UserPermission.DELETE
    ));

    // TODO - Does this return strings OR address
    fun getPermissions(): List<UserPermission> {
        return permissions
    }

    // IMPORTANT - Why do we create this?
    fun getAuthorities(): MutableCollection<GrantedAuthority> {

        val authorities: MutableCollection<GrantedAuthority> = mutableListOf(SimpleGrantedAuthority("ROLE_" + this.name))
        val permissions: List<GrantedAuthority> = this.getPermissions().map { SimpleGrantedAuthority(it.getContent()) }

        // [READ, WRITE, UPDATE, DELETE] - convert to strings
        permissions.map { element -> authorities.add(element) }

        return authorities
    }

}