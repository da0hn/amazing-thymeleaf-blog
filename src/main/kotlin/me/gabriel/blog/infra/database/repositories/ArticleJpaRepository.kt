package me.gabriel.blog.infra.database.repositories

import me.gabriel.blog.infra.database.entities.ArticleEntity
import org.springframework.data.jpa.repository.JpaRepository

/**
 * @author daohn
 * @since 20/07/2021
 */
interface ArticleJpaRepository : JpaRepository<ArticleEntity, Long>
