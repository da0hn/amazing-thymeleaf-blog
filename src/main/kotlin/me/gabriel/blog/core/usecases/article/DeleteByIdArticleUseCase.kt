package me.gabriel.blog.core.usecases.article

import me.gabriel.blog.core.domain.exceptions.ArticleNotFoundException
import me.gabriel.blog.core.ports.ArticleRepository
import me.gabriel.blog.core.usecases.UseCase
import org.springframework.stereotype.Component

/**
 * @author daohn
 * @since 16/08/2021
 */
@Component
class DeleteByIdArticleUseCase(
    private val repository: ArticleRepository
) : UseCase<DeleteByIdArticleInputValue, DeleteByIdArticleOutputValue> {


    override fun handle(input: DeleteByIdArticleInputValue): DeleteByIdArticleOutputValue {

        if (!repository.thisArticleExists(input.articleId))
            throw ArticleNotFoundException("It is not possible to delete an article that does not exist")

        repository.deleteArticleById(input.articleId)

        return DeleteByIdArticleOutputValue()
    }
}

data class DeleteByIdArticleInputValue(val articleId: Long) : UseCase.InputValue

class DeleteByIdArticleOutputValue : UseCase.OutputValue
