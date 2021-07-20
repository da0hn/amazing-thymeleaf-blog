package me.gabriel.blog.core.usecases.category

import me.gabriel.blog.core.ports.CategoryRepository
import me.gabriel.blog.core.ports.UseCase
import org.springframework.stereotype.Component

/**
 * @author daohn
 * @since 20/07/2021
 */
@Component
class CreateCategoryUseCase(
    private val categoryRepository: CategoryRepository
) : UseCase<CreateCategoryInputValue, CreateCategoryOutputValue> {

    override fun handle(input: CreateCategoryInputValue): CreateCategoryOutputValue {
        TODO("Not yet implemented")
    }

}

class CreateCategoryInputValue : UseCase.InputValue
class CreateCategoryOutputValue : UseCase.OutputValue

