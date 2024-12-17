package com.carolCase.settings_project_fullstack.repository

import ch.qos.logback.core.pattern.parser.OptionTokenizer
import com.carolCase.settings_project_fullstack.model.CustomUser
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository


@Repository
interface CustomUserRepository: JpaRepository<CustomUser, Long> {
    fun existsByUsername(username: String): Boolean
}