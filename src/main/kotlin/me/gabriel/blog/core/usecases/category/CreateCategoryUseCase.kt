package me.gabriel.blog.core.usecases.category

import me.gabriel.blog.core.ports.CategoryRepository
import me.gabriel.blog.core.usecases.UseCase

/**
 * @author daohn
 * @since 20/07/2021
 */
class CreateCategoryUseCase(
    private val categoryRepository: CategoryRepository
) : UseCase<CreateCategoryInputValue, CreateCategoryOutputValue> {

    override fun handle(input: CreateCategoryInputValue): CreateCategoryOutputValue {
        TODO("Not yet implemented")
    }

}

class CreateCategoryInputValue : UseCase.InputValue
class CreateCategoryOutputValue : UseCase.OutputValue


