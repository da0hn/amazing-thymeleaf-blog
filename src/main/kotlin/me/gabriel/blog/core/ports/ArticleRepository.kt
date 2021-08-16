package me.gabriel.blog.core.ports

import me.gabriel.blog.core.domain.Article
import me.gabriel.blog.core.domain.Author
import org.springframework.data.domain.Page
import java.util.*

/**
 * @author daohn
 * @since 04/08/2021
 */
interface ArticleRepository {

    fun findAllArticles(): List<Article>

    fun findAllPaginatedArticles(page: Int, elementPerPage: Int, userId: Long?): Page<Article>

    fun countArticle(): Long

    fun saveArticle(article: Article): Article

    fun findAuthorByUserId(userId: Long): Optional<Author>

    fun saveAuthor(author: Author): Author

    fun countAuthor(): Long

}
