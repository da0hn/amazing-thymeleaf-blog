package me.gabriel.blog.core.usecases.article

import me.gabriel.blog.core.domain.Article
import me.gabriel.blog.core.domain.exceptions.ArticleNotFoundException
import me.gabriel.blog.core.ports.ArticleRepository
import me.gabriel.blog.core.usecases.UseCase

/**
 * @author daohn
 * @since 16/08/2021
 */
class FindByIdArticleUseCase(
    private val repository: ArticleRepository
) : UseCase<FindByIdArticleInputValue, FindByIdArticleOutputValue> {

    override fun handle(input: FindByIdArticleInputValue): FindByIdArticleOutputValue {
        val article = repository
            .findArticleById(input.articleId)
            .orElseThrow { ArticleNotFoundException("Article with id ${input.articleId} not found.") }

        return FindByIdArticleOutputValue(article)
    }

}

data class FindByIdArticleInputValue(
    val articleId: Long
) : UseCase.InputValue

data class FindByIdArticleOutputValue(
    val article: Article
) : UseCase.OutputValue
