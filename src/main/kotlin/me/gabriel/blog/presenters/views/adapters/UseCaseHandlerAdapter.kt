package me.gabriel.blog.presenters.views.adapters

import me.gabriel.blog.core.ports.UseCase
import me.gabriel.blog.core.ports.UseCaseHandler
import org.springframework.stereotype.Service
import java.util.function.Function

/**
 * @author daohn
 * @since 17/07/2021
 */
@Service
class UseCaseHandlerAdapter : UseCaseHandler {
    override fun <R, I : UseCase.InputValue, O : UseCase.OutputValue> handle(
        useCase: UseCase<I, O>,
        input: I,
        outputMapper: Function<O, R>
    ): R {
        TODO("Not yet implemented")
    }
}
