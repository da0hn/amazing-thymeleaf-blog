package me.gabriel.blog.application.views.controllers

import me.gabriel.blog.application.views.dtos.ArticleFormDto
import me.gabriel.blog.core.domain.User
import me.gabriel.blog.core.usecases.UseCaseHandler
import me.gabriel.blog.core.usecases.article.CreateArticleInputValue
import me.gabriel.blog.core.usecases.article.CreateArticleUseCase
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import javax.servlet.http.HttpSession

/**
 * @author daohn
 * @since 20/07/2021
 */
@Controller
@RequestMapping("/articles")
class ArticleController(
    private val useCaseHandler: UseCaseHandler,
    private val createArticleUseCase: CreateArticleUseCase
) {

    private val logger = LoggerFactory.getLogger(javaClass)


    @GetMapping
    fun redirectToArticle(model: Model): String {
        logger.info("Redirect to article page")

        model.addAttribute("article", ArticleFormDto())

        return "articles"
    }

    @PostMapping
    fun create(articleForm: ArticleFormDto, session: HttpSession): String {

        logger.info("Creating article '${articleForm.title}'")

        val currentUser = session.getAttribute("currentUser") as User

        useCaseHandler.handle(
            createArticleUseCase,
            CreateArticleInputValue(articleForm, currentUser)
        ) {
        }

        logger.info("Redirect to index endpoint")

        return "redirect:/"
    }

}
