package me.gabriel.blog.application.views.dtos

/**
 * @author daohn
 * @since 18/07/2021
 */
data class UserLoginDto(
    var email: String?,
    var password: String?
) {
    constructor() : this(null, null)
}
