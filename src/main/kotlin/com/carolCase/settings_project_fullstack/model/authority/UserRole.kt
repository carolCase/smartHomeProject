package com.carolCase.settings_project_fullstack.model.authority

import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonValue
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

    // Map the enum to its string value
    @JsonValue
    fun toValue(): String {
        return this.name
    }

    companion object {
        // Create UserRole from JSON string, default to USER if input is invalid
        @JsonCreator
        @JvmStatic
        fun fromValue(value: String?): UserRole {
            return try {
                valueOf(value?.uppercase() ?: "USER") // Fallback to USER
            } catch (e: IllegalArgumentException) {
                USER // Default value
            }
        }
    }

    fun getPermissions(): List<UserPermission> {
        return permissions
    }

    fun getAuthorities(): MutableCollection<GrantedAuthority> {
        val authorities: MutableCollection<GrantedAuthority> = mutableListOf(SimpleGrantedAuthority("ROLE_" + this.name))
        val permissions: List<GrantedAuthority> = this.getPermissions().map { SimpleGrantedAuthority(it.getContent()) }
        permissions.map { element -> authorities.add(element) }
        return authorities
    }
}
