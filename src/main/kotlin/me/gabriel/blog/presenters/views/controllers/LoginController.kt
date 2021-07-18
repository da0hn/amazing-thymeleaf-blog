package me.gabriel.blog.presenters.views.controllers

import me.gabriel.blog.core.ports.UseCaseHandler
import me.gabriel.blog.core.usecases.user.LoginInputValue
import me.gabriel.blog.core.usecases.user.LoginUseCase
import me.gabriel.blog.presenters.views.dtos.UserLoginDto
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import javax.servlet.http.HttpSession

/**
 * @author daohn
 * @since 18/07/2021
 */
@Controller
@RequestMapping("/login")
class LoginController(
    private val useCaseHandler: UseCaseHandler,
    private val loginUseCase: LoginUseCase
) {

    private var logger: Logger = LoggerFactory.getLogger(javaClass)

    @GetMapping
    fun redirectToLogin(model: Model): String {
        logger.info("redirectToLogin()")
        model.addAttribute("user", UserLoginDto())
        return "login"
    }

    @PostMapping
    fun login(user: UserLoginDto, model: Model, session: HttpSession): String {
        logger.info("login()")

        try {
            val loggedUser = useCaseHandler.handle(
                loginUseCase,
                LoginInputValue(user),
            ) { outputValue -> outputValue.user }

            logger.info("Login successfully")

            session.setAttribute("currentUser", loggedUser)

        } catch (e: Exception) {
            e.message?.let {
                model.addAttribute("message", it)
                logger.error(it)
            }

            model.addAttribute("user", user)

            return "login"
        }
        return "redirect:/"
    }

    @GetMapping("/logout")
    fun logout(session: HttpSession): String {

        session.invalidate()

        return "redirect:/"
    }

}
