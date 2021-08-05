package me.gabriel.blog.core.domain

/**
 * @author daohn
 * @since 04/08/2021
 */
data class Author(
    var id: Long? = null,
    var about: String?,
    var user: User,
    var articles: List<Article>?
) {
    constructor(user: User) : this(null, null, user, null)
}
