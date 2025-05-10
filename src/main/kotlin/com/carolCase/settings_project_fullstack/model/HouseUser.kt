package com.carolCase.settings_project_fullstack.model

import jakarta.persistence.*
import java.time.LocalDateTime

@Entity
@Table(name = "houseusers")
data class HouseUser(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    @Column(nullable = false, unique = true)
    val email: String,

    @Column(name = "password_hash", nullable = false)
    val passwordHash: String,

    @Column(name = "full_name")
    val fullName: String? = null,

    @Enumerated(EnumType.STRING)
    val role: Role = Role.MEMBER,

    @Column(name = "created_at")
    val createdAt: LocalDateTime = LocalDateTime.now()
)

enum class Role {
    OWNER, MEMBER, GUEST
}
