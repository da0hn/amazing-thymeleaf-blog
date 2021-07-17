package me.gabriel.blog.infra.database.adapters

import me.gabriel.blog.core.domain.User
import me.gabriel.blog.core.ports.UserRepository
import me.gabriel.blog.infra.database.entities.UserEntity
import me.gabriel.blog.infra.database.repositories.UserJpaRepository
import org.springframework.stereotype.Component

/**
 * @author daohn
 * @since 16/07/2021
 */
@Component
class UserRepositoryAdapter(private val repository: UserJpaRepository) : UserRepository {
    override fun save(user: User) {
        val entity = UserEntity.from(user)

        repository.save(entity).also(::println)
    }
}
