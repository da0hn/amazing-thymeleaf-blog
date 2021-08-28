package me.gabriel.blog.application.config

import me.gabriel.blog.core.ports.UserRepository
import me.gabriel.blog.core.usecases.user.CreateUserUseCase
import me.gabriel.blog.core.usecases.user.LoginUseCase
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

/**
 * @author daohn
 * @since 28/08/2021
 */
@Configuration
class UseCaseUserModule {

    @Bean
    fun createUserUseCase(
        userRepository: UserRepository
    ) = CreateUserUseCase(
        userRepository
    )

    @Bean
    fun loginUseCase(
        userRepository: UserRepository
    ) = LoginUseCase(
        userRepository
    )

}
