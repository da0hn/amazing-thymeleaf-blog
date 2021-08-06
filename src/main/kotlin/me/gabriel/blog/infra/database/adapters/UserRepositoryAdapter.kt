package me.gabriel.blog.infra.database.adapters

import me.gabriel.blog.core.domain.User
import me.gabriel.blog.core.ports.UserRepository
import me.gabriel.blog.infra.database.entities.UserEntity
import me.gabriel.blog.infra.database.repositories.UserJpaRepository
import org.springframework.stereotype.Component
import java.util.*

/**
 * @author daohn
 * @since 16/07/2021
 */
@Component
class UserRepositoryAdapter(private val repository: UserJpaRepository) : UserRepository {
    override fun save(user: User): User {
        val userCreated = repository.save(UserEntity.from(user)).toUser()
        user.id = userCreated.id
        return userCreated
    }

    override fun findUserByEmail(email: String): Optional<User> {
        val optionalEntity = repository.findUserEntitiesByEmail(email)

        if (optionalEntity.isEmpty) {
            return Optional.empty()
        }

        return optionalEntity.map { user -> user.toUser() }
    }

    override fun count(): Long {
        return repository.count()
    }
}
