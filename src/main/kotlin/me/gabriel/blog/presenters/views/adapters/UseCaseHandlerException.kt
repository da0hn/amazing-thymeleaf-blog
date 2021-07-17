package me.gabriel.blog.presenters.views.adapters

/**
 * @author daohn
 * @since 17/07/2021
 */
class UseCaseHandlerException : RuntimeException {

    constructor() : super()

    constructor(message: String?) : super(message)
}
