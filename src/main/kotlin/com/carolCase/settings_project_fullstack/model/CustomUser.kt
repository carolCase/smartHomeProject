package com.carolCase.settings_project_fullstack.model

import com.carolCase.settings_project_fullstack.model.authority.UserRole
import jakarta.persistence.*
import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.Size


@Entity
@Table(name = "users")
 data class CustomUser(



   @field:NotEmpty
    @field:Size(min = 2, max = 16)
    val userName: String = "",

   @field:NotEmpty
    @field:Size(min = 3, max = 76)
    val password: String = "",



   val avatar: String = "",
   val isAdmin: Boolean = false,

   @Enumerated(value = EnumType.STRING)
   var role: UserRole = UserRole.USER,

   @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id: Long? = null) {

}
