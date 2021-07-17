package me.gabriel.blog.presenters.views.controllers

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping

/**
 * @author daohn
 * @since 14/07/2021
 */
@Controller
class SignUp {

    @GetMapping("/sign-up")
    fun signup(): String {
        return "sign-up"
    }

}
