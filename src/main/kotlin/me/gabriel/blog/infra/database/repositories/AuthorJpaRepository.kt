package me.gabriel.blog.infra.database.repositories

import me.gabriel.blog.infra.database.entities.AuthorEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import java.util.*

/**
 * @author daohn
 * @since 20/07/2021
 */
interface AuthorJpaRepository : JpaRepository<AuthorEntity, Long> {
    @Query(
        "SELECT author " +
                "FROM AuthorEntity author " +
                "WHERE author.user.id = :userId"
    )
    fun findByUserId(userId: Long): Optional<AuthorEntity>
}
