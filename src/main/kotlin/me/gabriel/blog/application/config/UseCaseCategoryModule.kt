package me.gabriel.blog.application.config

import me.gabriel.blog.core.ports.CategoryRepository
import me.gabriel.blog.core.usecases.category.CreateCategoryUseCase
import me.gabriel.blog.core.usecases.category.FindAllCategoryUseCase
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

/**
 * @author daohn
 * @since 28/08/2021
 */
@Configuration
class UseCaseCategoryModule {

    @Bean
    fun createCategoryUseCase(
        categoryRepository: CategoryRepository
    ) = CreateCategoryUseCase(
        categoryRepository
    )

    @Bean
    fun findAllCategoryUseCase(
        categoryRepository: CategoryRepository
    ) = FindAllCategoryUseCase(categoryRepository)

}
