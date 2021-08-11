package me.gabriel.blog.core.domain

/**
 * @author daohn
 * @since 04/08/2021
 */
data class Author(
    var id: Long? = null,
    var about: String?,
    var user: User,
    var articles: List<Article>?,

    var networks: SocialNetwork?
) {
    constructor(user: User) : this(null, null, user, null, null)

    constructor(
        user: User,
        about: String,
        networks: SocialNetwork
    ) : this(null, about, user, null, networks)
}
