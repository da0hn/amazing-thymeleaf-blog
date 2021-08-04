package me.gabriel.blog.infra.database.repositories

import me.gabriel.blog.infra.database.entities.AuthorEntity
import org.springframework.data.jpa.repository.JpaRepository

/**
 * @author daohn
 * @since 20/07/2021
 */
interface AuthorJpaRepository : JpaRepository<AuthorEntity, Long>
