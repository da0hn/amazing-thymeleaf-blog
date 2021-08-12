package me.gabriel.blog.application.views.controllers

import me.gabriel.blog.application.views.dtos.ArticleFormDto
import me.gabriel.blog.core.domain.User
import me.gabriel.blog.core.usecases.UseCaseHandler
import me.gabriel.blog.core.usecases.article.CreateArticleInputValue
import me.gabriel.blog.core.usecases.article.CreateArticleUseCase
import me.gabriel.blog.core.usecases.article.FindAllArticleInputValue
import me.gabriel.blog.core.usecases.article.FindAllArticleUseCase
import me.gabriel.blog.core.usecases.category.FindAllCategoryInputValue
import me.gabriel.blog.core.usecases.category.FindAllCategoryUseCase
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.servlet.mvc.support.RedirectAttributes
import javax.servlet.http.HttpSession

/**
 * @author daohn
 * @since 20/07/2021
 */
@Controller
@RequestMapping("/articles")
class ArticleController(
    private val useCaseHandler: UseCaseHandler,
    private val createArticleUseCase: CreateArticleUseCase,
    private val findAllArticleUseCase: FindAllArticleUseCase,
    private val findAllCategoryUseCase: FindAllCategoryUseCase
) {

    private val logger = LoggerFactory.getLogger(javaClass)


    @GetMapping
    fun redirectToArticle(model: Model): String {
        logger.info("Redirect to article page")

        model.addAttribute("article", ArticleFormDto())

        return "articles"
    }

    @GetMapping("/list")
    fun redirectToArticleList(model: Model): String {
        logger.info("Redirect to articles list page")

        useCaseHandler.handle(
            findAllCategoryUseCase,
            FindAllCategoryInputValue()
        ) {
            model.addAttribute("categories", it.categories)
        }

        useCaseHandler.handle(
            findAllArticleUseCase,
            FindAllArticleInputValue(0, 10)
        ) {
            model.addAttribute("articles", it.articles.content)
        }

        return "articles-list"
    }

    @PostMapping
    fun create(
        articleForm: ArticleFormDto,
        session: HttpSession,
        redirectAttributes: RedirectAttributes
    ): String {

        logger.info("Creating article '${articleForm.title}'")

        val currentUser = session.getAttribute("currentUser") as User

        useCaseHandler.handle(
            createArticleUseCase,
            CreateArticleInputValue(articleForm, currentUser)
        ) {
        }

        logger.info("Redirect to index endpoint")

        redirectAttributes.addFlashAttribute("message", "Artigo criado com sucesso")

        return "redirect:/"
    }

}
