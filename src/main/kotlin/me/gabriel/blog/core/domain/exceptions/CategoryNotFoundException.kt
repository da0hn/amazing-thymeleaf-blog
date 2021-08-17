package me.gabriel.blog.core.domain.exceptions

/**
 * @author daohn
 * @since 16/08/2021
 */
class CategoryNotFoundException : RuntimeException {

    constructor() : super()

    constructor(message: String?) : super(message)
}
