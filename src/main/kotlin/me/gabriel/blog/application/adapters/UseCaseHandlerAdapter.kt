package me.gabriel.blog.application.adapters

import me.gabriel.blog.core.usecases.UseCase
import me.gabriel.blog.core.usecases.UseCaseHandler
import org.springframework.stereotype.Service
import java.util.function.Function
import java.util.stream.Stream

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
        return Stream.of(useCase.handle(input))
            .map(outputMapper)
            .findAny()
            .orElseThrow { UseCaseHandlerException("Output value not found") }
    }
}
