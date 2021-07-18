package me.gabriel.blog.infra.database.repositories

import me.gabriel.blog.infra.database.entities.UserEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.*

/**
 * @author daohn
 * @since 16/07/2021
 */
@Repository
interface UserJpaRepository : JpaRepository<UserEntity, Long> {


    fun findUserEntitiesByEmail(email: String) : Optional<UserEntity>
}
