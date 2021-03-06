package me.gabriel.blog.application.views.controllers

import me.gabriel.blog.application.views.dtos.UserFormDto
import me.gabriel.blog.core.usecases.UseCaseHandler
import me.gabriel.blog.core.usecases.user.CreateUserInputValue
import me.gabriel.blog.core.usecases.user.CreateUserUseCase
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
    fun redirectToSignUp(model: Model): String {
        logger.info("Redirect to sign up page")
        model.addAttribute("user", UserFormDto())
        return "sign-up"
    }

    @PostMapping
    fun signup(user: UserFormDto, model: Model): String {
        logger.info("Creating user ${user.name}")
        try {
            useCaseHandler.handle(
                createUserUseCase,
                CreateUserInputValue(user)
            ) { output -> output }

            logger.info("User ${user.name} created successfully.")

            return "redirect:/login"

        } catch (e: Exception) {
            e.message?.let {
                logger.error(it)
                model.addAttribute("message", it)
            }
            model.addAttribute("user", user)
            return "sign-up"
        }
    }
}
