package com.carolCase.settings_project_fullstack.model

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.Size


@Entity

class CustomUser(
    @field:NotEmpty
    @field:Size(min = 2, max = 16)
    val name: String = "",

    @field:NotEmpty
    @field:Size(min = 3, max = 6)   //if b crypt max at least 74
    val password: String = "",



    val avatar: String = "",
    val isAdmin: Boolean = false,

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id: Long? = null)
