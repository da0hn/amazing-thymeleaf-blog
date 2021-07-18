package me.gabriel.blog.core.domain.exceptions

/**
 * @author daohn
 * @since 18/07/2021
 */
class UserNotFoundException : RuntimeException {

    constructor() : super()

    constructor(message: String) : super(message)
}
