package me.gabriel.blog.core.usecases.article

import me.gabriel.blog.core.domain.Article
import me.gabriel.blog.core.ports.ArticleRepository
import me.gabriel.blog.core.usecases.UseCase
import org.springframework.data.domain.Page

/**
 * @author daohn
 * @since 06/08/2021
 */
class FindAllArticleUseCase(
    private val articleRepository: ArticleRepository
) : UseCase<FindAllArticleInputValue, FindAllArticleOutputValue> {

    override fun handle(input: FindAllArticleInputValue): FindAllArticleOutputValue {

        val page = input.page

        val articles = articleRepository.findAllPaginatedArticles(
            page,
            input.elementsPerPage,
            input.userId,
            input.categoryId
        )

        val next = if (page >= articles.totalElements - 1) page else page + 1
        val previous = if (page <= 0) 0 else page - 1

        return FindAllArticleOutputValue(
            articles,
            next,
            previous
        )
    }

}

class FindAllArticleInputValue(
    val page: Int,
    val elementsPerPage: Int = 1,
    val userId: Long? = null,
    val categoryId: Long? = null
) : UseCase.InputValue

class FindAllArticleOutputValue(
    val articles: Page<Article>,
    val next: Int,
    val previous: Int
) : UseCase.OutputValue
