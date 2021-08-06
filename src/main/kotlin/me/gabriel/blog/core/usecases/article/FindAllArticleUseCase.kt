package me.gabriel.blog.core.usecases.article

import me.gabriel.blog.core.domain.Article
import me.gabriel.blog.core.ports.ArticleRepository
import me.gabriel.blog.core.usecases.UseCase
import org.springframework.stereotype.Component

/**
 * @author daohn
 * @since 06/08/2021
 */
@Component
class FindAllArticleUseCase(
    private val articleRepository: ArticleRepository
) : UseCase<FindAllArticleInputValue, FindAllArticleOutputValue> {

    override fun handle(input: FindAllArticleInputValue): FindAllArticleOutputValue {
        return FindAllArticleOutputValue(articleRepository.findAllArticles())
    }

}

class FindAllArticleInputValue : UseCase.InputValue
class FindAllArticleOutputValue(
    val articles: List<Article>
) : UseCase.OutputValue
