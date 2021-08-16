package me.gabriel.blog.core.domain

import java.time.LocalDateTime

/**
 * @author daohn
 * @since 20/07/2021
 */
data class Article(
    var id: Long? = null,
    var title: String,
    var subTitle: String,
    var content: String,
    var date: LocalDateTime? = null,
    var author: Author,
    var category: Category
)
