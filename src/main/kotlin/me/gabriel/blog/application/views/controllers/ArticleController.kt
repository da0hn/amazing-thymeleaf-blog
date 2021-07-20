package me.gabriel.blog.application.views.controllers

import me.gabriel.blog.application.views.dtos.ArticleFormDto
import me.gabriel.blog.core.domain.Article
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping

/**
 * @author daohn
 * @since 20/07/2021
 */
@Controller
@RequestMapping("/articles")
class ArticleController {

    @GetMapping
    fun articles(model: Model): String {

        model.addAttribute("article", ArticleFormDto())

        return "articles"
    }

    @PostMapping
    fun createArticle(article: Article): String {
        return "articles"
    }

}
