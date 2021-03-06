package me.gabriel.blog.infra.database.entities

import me.gabriel.blog.core.domain.Category
import org.hibernate.Hibernate
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.OneToMany

/**
 * @author daohn
 * @since 20/07/2021
 */
@Entity
data class CategoryEntity(
    @Id
    @GeneratedValue
    var id: Long? = null,
    var name: String,
    @OneToMany(mappedBy = "category")
    var articles: List<ArticleEntity>?
) {
    companion object {
        fun from(category: Category): CategoryEntity {
            return CategoryEntity(
                category.id,
                category.name!!,
                category.articles?.map(ArticleEntity::from)
            )
        }
    }

    fun toCategory(): Category {
        return Category(this.id, this.name, null)
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || Hibernate.getClass(this) != Hibernate.getClass(other)) return false
        other as CategoryEntity

        return id != null && id == other.id
    }

    override fun hashCode(): Int = 1625513757

    @Override
    override fun toString(): String {
        return this::class.simpleName + "(id = $id )"
    }
}
