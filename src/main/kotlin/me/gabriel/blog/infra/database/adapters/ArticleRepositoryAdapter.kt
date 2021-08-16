package me.gabriel.blog.infra.database.adapters

import me.gabriel.blog.core.domain.Article
import me.gabriel.blog.core.domain.Author
import me.gabriel.blog.core.ports.ArticleRepository
import me.gabriel.blog.infra.database.entities.ArticleEntity
import me.gabriel.blog.infra.database.entities.AuthorEntity
import me.gabriel.blog.infra.database.repositories.ArticleJpaRepository
import me.gabriel.blog.infra.database.repositories.AuthorJpaRepository
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageRequest
import org.springframework.stereotype.Component
import java.util.*

/**
 * @author daohn
 * @since 04/08/2021
 */
@Component
class ArticleRepositoryAdapter(
    private val articleRepository: ArticleJpaRepository,
    private val authorRepository: AuthorJpaRepository
) : ArticleRepository {

    override fun findAllArticles(): List<Article> = this.articleRepository.findAll().map(ArticleEntity::toArticle)

    override fun findAllPaginatedArticles(page: Int, elementPerPage: Int, userId: Long?, categoryId: Long?): Page<Article> =
        this.articleRepository
            .findAll(PageRequest.of(page, elementPerPage), userId, categoryId)
            .map(ArticleEntity::toArticle)

    override fun findArticleById(id: Long): Optional<Article> = this.articleRepository.findById(id).map(ArticleEntity::toArticle)

    override fun countArticle(): Long = this.articleRepository.count()

    override fun saveArticle(article: Article): Article = this.articleRepository
        .save(ArticleEntity.from(article)).toArticle()

    override fun findAuthorByUserId(userId: Long): Optional<Author> =
        this.authorRepository
            .findByUserId(userId)
            .map(AuthorEntity::toAuthor)


    override fun saveAuthor(author: Author): Author = this.authorRepository
        .save(AuthorEntity.from(author))
        .toAuthor()

    override fun countAuthor(): Long = authorRepository.count()
}
