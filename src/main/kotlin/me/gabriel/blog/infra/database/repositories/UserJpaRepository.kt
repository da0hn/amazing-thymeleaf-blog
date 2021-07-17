package me.gabriel.blog.data.database.repositories

import me.gabriel.blog.data.database.entities.UserEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

/**
 * @author daohn
 * @since 16/07/2021
 */
@Repository
interface UserJpaRepository : JpaRepository<UserEntity, Long>
