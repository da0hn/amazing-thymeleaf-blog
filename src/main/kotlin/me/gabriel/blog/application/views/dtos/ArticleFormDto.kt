package me.gabriel.blog.application.views.dtos

/**
 * @author daohn
 * @since 20/07/2021
 */
data class ArticleFormDto(
    var id: Long? = null,
    var title: String? = null,
    var subTitle: String? = null,
    var content: String? = null,
    var categoryId: Long? = null,
)
