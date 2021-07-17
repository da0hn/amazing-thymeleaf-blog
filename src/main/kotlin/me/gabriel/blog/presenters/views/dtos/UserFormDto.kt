package me.gabriel.blog.presenters.views.dtos

/**
 * @author daohn
 * @since 16/07/2021
 */
data class UserFormDto(
    val name: String,
    val email: String,
    val password: String,
    val confirmPassword: String
)