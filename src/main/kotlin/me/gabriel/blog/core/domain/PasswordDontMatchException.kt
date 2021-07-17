package me.gabriel.blog.core.domain

/**
 * @author daohn
 * @since 17/07/2021
 */
class PasswordDontMatchException : RuntimeException {

    constructor() : super()

    constructor(message: String?) : super(message)


}
