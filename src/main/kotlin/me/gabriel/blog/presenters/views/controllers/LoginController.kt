package me.gabriel.blog.presenters.views.controllers

import org.slf4j.Logger
import org.slf4j.LoggerFactory
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

    private var logger: Logger =  LoggerFactory.getLogger(javaClass)

    @GetMapping
    fun login() : String {
        logger.info("login()")
        return "login"
    }

}
