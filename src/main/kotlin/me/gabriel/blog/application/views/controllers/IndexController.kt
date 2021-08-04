package me.gabriel.blog.application.views.controllers

import me.gabriel.blog.core.usecases.UseCaseHandler
import me.gabriel.blog.core.usecases.category.FindAllCategoryInputValue
import me.gabriel.blog.core.usecases.category.FindAllCategoryOutputValue
import me.gabriel.blog.core.usecases.category.FindAllCategoryUseCase
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping

/**
 * @author daohn
 * @since 16/07/2021
 */
@Controller
@RequestMapping("/")
class IndexController(
    private val useCaseHandler: UseCaseHandler,
    private val findAllCategoryUseCase: FindAllCategoryUseCase
) {

    private val logger: Logger = LoggerFactory.getLogger(javaClass)

    @GetMapping
    fun index(model: Model): String {

        logger.info("index()")

        val categories = useCaseHandler.handle(
            findAllCategoryUseCase,
            FindAllCategoryInputValue(),
            FindAllCategoryOutputValue::categories
        )

        model.addAttribute("categories", categories)

        return "index"
    }

}
