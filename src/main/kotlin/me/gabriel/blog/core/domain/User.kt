package me.gabriel.blog.core.domain

/**
 * @author daohn
 * @since 17/07/2021
 */
class User(var name: String?, var email: String?, var password: String?) {

    init {
        if (name == null) {
            throw IllegalStateException("Name must be not null")
        }
        if (email == null) {
            throw IllegalStateException("Email must be not null")
        }
        if (password == null) {
            throw IllegalStateException("Password must be not null")
        }
    }

    constructor(name: String?, email: String?, password: String?, confirmPassword: String) : this(name, email, password) {
        if (password != confirmPassword) {
            throw InvalidPasswordException("Password don't match!")
        }
    }

}
