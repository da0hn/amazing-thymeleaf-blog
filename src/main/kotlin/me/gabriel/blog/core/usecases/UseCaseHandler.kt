package me.gabriel.blog.core.usecases

import java.util.function.Function

/**
 * @author daohn
 * @since 17/07/2021
 */
interface UseCaseHandler {

    fun <R, I : UseCase.InputValue, O : UseCase.OutputValue> handle(
        useCase: UseCase<I, O>,
        input: I,
        outputMapper: Function<O, R>
    ): R

}
