package me.gabriel.blog.infra.database.repositories

import me.gabriel.blog.infra.database.entities.ArticleEntity
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query

/**
 * @author daohn
 * @since 20/07/2021
 */
interface ArticleJpaRepository : JpaRepository<ArticleEntity, Long> {


    @Query(
        "SELECT article FROM ArticleEntity article " +
                "JOIN article.category category " +
                "JOIN article.author author " +
                "JOIN author.user user " +
                "WHERE (user.id = :userId OR :userId IS NULL) " +
                "AND (category.id = :categoryId OR :categoryId IS NULL) " +
                "ORDER BY article.createdAt DESC "
    )
    fun findAll(pageable: Pageable, userId: Long?, categoryId: Long?): Page<ArticleEntity>
}
