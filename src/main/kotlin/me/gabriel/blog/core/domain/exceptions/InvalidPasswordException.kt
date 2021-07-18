package me.gabriel.blog.core.domain.exceptions

/**
 * @author daohn
 * @since 17/07/2021
 */
class InvalidPasswordException : RuntimeException {

    constructor() : super()

    constructor(message: String) : super(message)


}
