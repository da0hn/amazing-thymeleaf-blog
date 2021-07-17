package me.gabriel.blog.presenters.views.controllers

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping

/**
 * @author daohn
 * @since 16/07/2021
 */
@Controller
@RequestMapping("/")
class IndexController {

    @GetMapping
    fun index(): String {
        println("index()...")
        return "index"
    }

}
