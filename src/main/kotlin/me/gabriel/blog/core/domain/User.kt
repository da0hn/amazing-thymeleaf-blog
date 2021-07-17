package me.gabriel.blog.core.domain

/**
 * @author daohn
 * @since 17/07/2021
 */
class User(var name: String, var email: String, var password: String, confirmPassword: String?) {

    init {
        if(password != confirmPassword) {
            throw PasswordDontMatchException("Password don't match!")
        }
    }


}
