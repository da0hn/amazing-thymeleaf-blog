package me.gabriel.blog.core.usecases.user

import me.gabriel.blog.core.domain.User
import me.gabriel.blog.core.domain.exceptions.InvalidPasswordException
import me.gabriel.blog.core.domain.exceptions.UserNotFoundException
import me.gabriel.blog.core.ports.UseCase
import me.gabriel.blog.core.ports.UserRepository
import me.gabriel.blog.presenters.views.dtos.UserLoginDto
import org.springframework.stereotype.Component

/**
 * @author daohn
 * @since 18/07/2021
 */
@Component
class LoginUseCase(
    private val userRepository: UserRepository
) : UseCase<LoginInputValue, LoginOutputValue> {

    override fun handle(input: LoginInputValue): LoginOutputValue {
        val userLoginDto = input.user

        this.validate(userLoginDto)

        val user = this.userRepository
            .findUserByEmail(userLoginDto.email!!)
            .orElseThrow { UserNotFoundException("There is no user with this email") }

        this.verifyPassword(user, userLoginDto)

        return LoginOutputValue(user)

    }

    private fun verifyPassword(user: User, userLoginDto: UserLoginDto) {
        if (user.password != userLoginDto.password) {
            throw InvalidPasswordException("Invalid password")
        }
    }

    private fun validate(dto: UserLoginDto) {

        if (dto.email.isNullOrEmpty()) {
            throw IllegalStateException("Email must be not empty")
        }
        if (dto.password.isNullOrEmpty()) {
            throw IllegalStateException("Password must be not empty")
        }

    }

}

data class LoginInputValue(
    val user: UserLoginDto
) : UseCase.InputValue

data class LoginOutputValue(val user: User) : UseCase.OutputValue
