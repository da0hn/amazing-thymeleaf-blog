package me.gabriel.blog.infra.database.entities

import org.hibernate.Hibernate
import javax.persistence.*

/**
 * @author daohn
 * @since 20/07/2021
 */
@Entity
data class AuthorEntity(
    @Id
    @GeneratedValue
    var id: Long? = null,
    var about: String,

    @OneToOne
    var user: UserEntity,

    @OneToMany(mappedBy = "author")
    var articles: List<ArticleEntity>
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || Hibernate.getClass(this) != Hibernate.getClass(other)) return false
        other as AuthorEntity

        return id != null && id == other.id
    }

    override fun hashCode(): Int = 2011850703

    @Override
    override fun toString(): String {
        return this::class.simpleName + "(id = $id , about = $about )"
    }
}