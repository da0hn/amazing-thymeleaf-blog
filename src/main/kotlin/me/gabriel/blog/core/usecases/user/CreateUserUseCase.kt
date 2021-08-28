package me.gabriel.blog.core.usecases.user

import me.gabriel.blog.application.views.dtos.UserFormDto
import me.gabriel.blog.core.domain.User
import me.gabriel.blog.core.ports.UserRepository
import me.gabriel.blog.core.usecases.UseCase

/**
 * @author daohn
 * @since 17/07/2021
 */
class CreateUserUseCase(private val userRepository: UserRepository) : UseCase<CreateUserInputValue, CreateUserOutputValue> {

    override fun handle(input: CreateUserInputValue): CreateUserOutputValue {

        val user = createUser(input)

        userRepository.save(user)

        return CreateUserOutputValue()
    }

    private fun createUser(input: CreateUserInputValue): User {
        return User(
            input.user.name,
            input.user.email,
            input.user.password,
            input.user.confirmPassword,
        )
    }

}

data class CreateUserInputValue(val user: UserFormDto) : UseCase.InputValue

class CreateUserOutputValue : UseCase.OutputValue


