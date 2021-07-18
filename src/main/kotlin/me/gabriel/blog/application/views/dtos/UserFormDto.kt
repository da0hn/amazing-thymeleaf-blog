package me.gabriel.blog.application.views.dtos

/**
 * @author daohn
 * @since 16/07/2021
 */
data class UserFormDto(
    var name: String = "",
    var email: String = "",
    var password: String = "",
    var confirmPassword: String = ""
)
