package me.gabriel.blog.presenters.views.controllers

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping

/**
 * @author daohn
 * @since 18/07/2021
 */
@Controller
@RequestMapping("/login")
class LoginController {

    @GetMapping
    fun login() : String {
        return "login"
    }

}
