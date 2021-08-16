package me.gabriel.blog.core.domain.exceptions

/**
 * @author daohn
 * @since 16/08/2021
 */
class ArticleNotFoundException : RuntimeException {
    constructor() : super()

    constructor(message: String?) : super(message)
}
