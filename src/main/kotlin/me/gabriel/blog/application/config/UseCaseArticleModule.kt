package me.gabriel.blog.application.config

import me.gabriel.blog.core.ports.ArticleRepository
import me.gabriel.blog.core.ports.CategoryRepository
import me.gabriel.blog.core.usecases.article.CreateArticleUseCase
import me.gabriel.blog.core.usecases.article.DeleteByIdArticleUseCase
import me.gabriel.blog.core.usecases.article.FindAllArticleUseCase
import me.gabriel.blog.core.usecases.article.FindByIdArticleUseCase
import me.gabriel.blog.infra.logger.adapters.Slf4jLoggerAdapter
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

/**
 * @author daohn
 * @since 28/08/2021
 */
@Configuration
class UseCaseArticleModule {

    @Bean
    fun createArticleUseCase(
        articleRepository: ArticleRepository,
        categoryRepository: CategoryRepository,
    ) = CreateArticleUseCase(
        articleRepository,
        categoryRepository,
        Slf4jLoggerAdapter(CreateArticleUseCase::class.java)
    )

    @Bean
    fun deleteByIdArticleUseCase(
        articleRepository: ArticleRepository,
    ) = DeleteByIdArticleUseCase(
        articleRepository
    )

    @Bean
    fun findAllArticleUseCase(
        articleRepository: ArticleRepository
    ) = FindAllArticleUseCase(articleRepository)

    @Bean
    fun findByIdArticleUseCase(
        articleRepository: ArticleRepository
    ) = FindByIdArticleUseCase(articleRepository)
}
