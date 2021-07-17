package me.gabriel.blog.core.ports

import me.gabriel.blog.core.domain.User

/**
 * @author daohn
 * @since 16/07/2021
 */
interface UserRepository {

    fun save(user: User)

}
