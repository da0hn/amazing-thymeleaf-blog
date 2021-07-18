package me.gabriel.blog.core.domain

import me.gabriel.blog.core.domain.exceptions.InvalidPasswordException

/**
 * @author daohn
 * @since 17/07/2021
 */
class User(var name: String?, var email: String?, var password: String?) {

    init {
        if (name.isNullOrEmpty()) {
            throw IllegalStateException("Name must be not empty")
        }
        if (email.isNullOrEmpty()) {
            throw IllegalStateException("Email must be not empty")
        }
        if (password.isNullOrEmpty()) {
            throw IllegalStateException("Password must be not empty")
        }
    }

    constructor(name: String?, email: String?, password: String?, confirmPassword: String) : this(name, email, password) {
        if (password != confirmPassword) {
            throw InvalidPasswordException("Password don't match!")
        }
    }

}
