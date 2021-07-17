package me.gabriel.blog.presenters.views.controllers

import me.gabriel.blog.core.ports.UseCaseHandler
import me.gabriel.blog.core.usecases.user.CreateUserInputValue
import me.gabriel.blog.core.usecases.user.CreateUserUseCase
import me.gabriel.blog.presenters.views.dtos.UserFormDto
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping

/**
 * @author daohn
 * @since 14/07/2021
 */
@Controller
@RequestMapping("/sign-up")
class SignUpController(
    private val useCaseHandler: UseCaseHandler,
    private val createUserUseCase: CreateUserUseCase
) {

    private val logger: Logger = LoggerFactory.getLogger(javaClass)

    @GetMapping
    fun form(model: Model): String {
        logger.info("form()")
        model.addAttribute("user", UserFormDto())
        return "sign-up"
    }

    @PostMapping
    fun signup(user: UserFormDto, model: Model): String {
        logger.info("signup()")
        try {
            useCaseHandler.handle(
                createUserUseCase,
                CreateUserInputValue(user)
            ) { output -> output }
        } catch (e: Exception) {
            e.message?.let {
                logger.error(it)
                model.addAttribute("message", it)
            }
            model.addAttribute("user", user)
            return "sign-up"
        }
        return "redirect:/"
    }
}
