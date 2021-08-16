package me.gabriel.blog.core.usecases.article

import me.gabriel.blog.application.views.dtos.ArticleFormDto
import me.gabriel.blog.core.domain.Article
import me.gabriel.blog.core.domain.Author
import me.gabriel.blog.core.domain.Category
import me.gabriel.blog.core.domain.User
import me.gabriel.blog.core.ports.ArticleRepository
import me.gabriel.blog.core.ports.CategoryRepository
import me.gabriel.blog.core.usecases.UseCase
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Component
import java.time.LocalDateTime

/**
 * @author daohn
 * @since 04/08/2021
 */
@Component
class CreateArticleUseCase(
    private val articleRepository: ArticleRepository,
    private val categoryRepository: CategoryRepository
) : UseCase<CreateArticleInputValue, CreateArticleOutputValue> {

    private val logger = LoggerFactory.getLogger(javaClass)

    override fun handle(input: CreateArticleInputValue): CreateArticleOutputValue {


        val author = createAuthorRelationship(input.user)

        val category = createCategoryRelationship(input.article.categoryId)


        val articleToCreate = Article(
            id = input.article.id,
            title = input.article.title!!,
            subTitle = input.article.subTitle!!,
            content = input.article.content!!,
            author = author,
            category = category
        )

        logger.info("Relationship with '${articleToCreate.author.user.name}' created successfully")

        articleToCreate.date = LocalDateTime.now()

        this.articleRepository.saveArticle(articleToCreate)
            .also { logger.info("Article '${it.title}' created by '${it.author.user.name}' successfully") }

        return CreateArticleOutputValue()
    }

    private fun createCategoryRelationship(categoryId: Long?): Category {
        return categoryRepository
            .findById(categoryId!!)
            .orElseThrow()
    }

    private fun createAuthorRelationship(
        user: User,
    ): Author {
        val authorNullable = articleRepository.findAuthorByUserId(user.id!!)

        if (authorNullable.isEmpty) {
            val authorToCreate = Author(user)
            return articleRepository.saveAuthor(authorToCreate)
        }

        return authorNullable.get()
    }

}

class CreateArticleInputValue(val article: ArticleFormDto, val user: User) : UseCase.InputValue

class CreateArticleOutputValue : UseCase.OutputValue
