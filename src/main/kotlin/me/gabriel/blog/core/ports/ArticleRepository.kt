package me.gabriel.blog.core.ports

import me.gabriel.blog.core.domain.Article
import me.gabriel.blog.core.domain.Author
import java.util.*

/**
 * @author daohn
 * @since 04/08/2021
 */
interface ArticleRepository {

    fun findAllArticles(): List<Article>

    fun countArticle(): Long

    fun saveArticle(article: Article): Article

    fun findAuthorByUserId(userId: Long): Optional<Author>

    fun saveAuthor(author: Author): Author

    fun countAuthor(): Long

}
