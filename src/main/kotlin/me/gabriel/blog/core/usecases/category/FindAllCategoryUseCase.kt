package me.gabriel.blog.core.usecases.category

import me.gabriel.blog.core.domain.Category
import me.gabriel.blog.core.ports.CategoryRepository
import me.gabriel.blog.core.usecases.UseCase

/**
 * @author daohn
 * @since 20/07/2021
 */
class FindAllCategoryUseCase(
    private val categoryRepository: CategoryRepository
) : UseCase<FindAllCategoryInputValue, FindAllCategoryOutputValue> {

    override fun handle(input: FindAllCategoryInputValue): FindAllCategoryOutputValue {
        val categories = categoryRepository.findAll()
        return FindAllCategoryOutputValue(categories)
    }

}

class FindAllCategoryInputValue : UseCase.InputValue

data class FindAllCategoryOutputValue(
    val categories: List<Category>
) : UseCase.OutputValue
