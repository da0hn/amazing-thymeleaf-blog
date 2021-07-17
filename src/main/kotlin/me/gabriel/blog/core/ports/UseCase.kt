package me.gabriel.blog.core.ports

/**
 * @author daohn
 * @since 17/07/2021
 */
interface UseCase<I : UseCase.InputValue, O : UseCase.OutputValue> {
    fun handle(input: I): O

    interface InputValue

    interface OutputValue
}




