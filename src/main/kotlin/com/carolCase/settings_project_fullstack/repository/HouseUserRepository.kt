package com.carolCase.settings_project_fullstack.repository

import com.carolCase.settings_project_fullstack.model.HouseUser
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface HouseUserRepository : JpaRepository<HouseUser, Long> {
    fun findByEmail(email: String): HouseUser?
}
