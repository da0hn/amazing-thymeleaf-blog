package me.gabriel.blog.infra.database.entities

import org.hibernate.Hibernate
import org.springframework.data.annotation.CreatedDate
import java.time.LocalDateTime
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.ManyToOne

/**
 * @author daohn
 * @since 20/07/2021
 */
@Entity
data class ArticleEntity(
    @Id
    @GeneratedValue
    var id: Long? = null,
    var title: String,
    var subTitle: String,
    var content: String,
    @CreatedDate
    var date: LocalDateTime,
    @ManyToOne
    var author: AuthorEntity
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || Hibernate.getClass(this) != Hibernate.getClass(other)) return false
        other as ArticleEntity

        return id != null && id == other.id
    }

    override fun hashCode(): Int = 1851885445

    @Override
    override fun toString(): String {
        return this::class.simpleName + "(id = $id , title = $title)"
    }
}
