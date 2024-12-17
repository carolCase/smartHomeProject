package com.carolCase.settings_project_fullstack.model.authority

enum class UserPermission(private val content: String) {
    READ("READ"),
    WRITE("WRITE"),
    UPDATE("UPDATE"),
    DELETE("DELETE");

    fun getContent(): String = content
}