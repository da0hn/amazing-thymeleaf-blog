package me.gabriel.blog.core.ports

import me.gabriel.blog.core.domain.User
import org.springframework.stereotype.Component

/**
 * @author daohn
 * @since 16/07/2021
 */
@Component
interface UserRepository {

    fun save(user: User)

}
