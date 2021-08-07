package me.gabriel.blog.application.views.controllers

import me.gabriel.blog.core.usecases.UseCaseHandler
import me.gabriel.blog.core.usecases.article.FindAllArticleInputValue
import me.gabriel.blog.core.usecases.article.FindAllArticleUseCase
import me.gabriel.blog.core.usecases.category.FindAllCategoryInputValue
import me.gabriel.blog.core.usecases.category.FindAllCategoryUseCase
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam

/**
 * @author daohn
 * @since 16/07/2021
 */
@Controller
@RequestMapping("/")
class IndexController(
    private val useCaseHandler: UseCaseHandler,
    private val findAllCategoryUseCase: FindAllCategoryUseCase,
    private val findAllArticleUseCase: FindAllArticleUseCase,
) {

    private val logger: Logger = LoggerFactory.getLogger(javaClass)

    @GetMapping
    fun index(
        model: Model,
        @RequestParam(name = "page", required = false, defaultValue = "0") page: Int,
    ): String {

        logger.info("Searching all categories...")

        useCaseHandler.handle(
            findAllCategoryUseCase,
            FindAllCategoryInputValue(),
        ) {
            model.addAttribute("categories", it.categories)
        }

        logger.info("Searching all articles...")

        useCaseHandler.handle(
            findAllArticleUseCase,
            FindAllArticleInputValue(page),
        ) {
            model.addAttribute("articles", it.articles)
            model.addAttribute("nextArticle", it.next)
            model.addAttribute("previousArticle", it.previous)
            model.addAttribute("isFirst", it.articles.isFirst)
            model.addAttribute("isLast", it.articles.isLast)
        }

        logger.info("Redirect to index page")

        return "index"
    }

}
