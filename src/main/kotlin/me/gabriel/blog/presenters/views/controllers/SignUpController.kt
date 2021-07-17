package me.gabriel.blog.presenters.views.controllers

import me.gabriel.blog.core.ports.UseCaseHandler
import me.gabriel.blog.core.usecases.user.CreateUserUseCase
import me.gabriel.blog.presenters.views.dtos.UserFormDto
import org.springframework.stereotype.Controller
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

    @GetMapping
    fun form(): String {
        println("form()")
        return "sign-up"
    }

    @PostMapping
    fun signup(user: UserFormDto): String {
        println("signup()")
        println(user)
        return "redirect:/"
    }
}
