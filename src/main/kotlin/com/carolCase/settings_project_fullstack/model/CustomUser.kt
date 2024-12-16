package com.carolCase.settings_project_fullstack.model

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id


@Entity
class CustomUser {
    val name: String = ""
    val password: String = ""
    val avatar: String = ""
    val isAdmin: Boolean = false

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
     val id: Long? = null
}