package me.gabriel.blog.core.domain

/**
 * @author daohn
 * @since 20/07/2021
 */
data class Category(
    var id: Long?,
    var name: String?,
    var articles: List<Article>?
)
