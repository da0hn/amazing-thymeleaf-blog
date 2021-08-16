package me.gabriel.blog.infra.database.adapters

import me.gabriel.blog.core.domain.Category
import me.gabriel.blog.core.ports.CategoryRepository
import me.gabriel.blog.infra.database.entities.CategoryEntity
import me.gabriel.blog.infra.database.repositories.CategoryJpaRepository
import org.springframework.stereotype.Component
import java.util.*

/**
 * @author daohn
 * @since 20/07/2021
 */
@Component
class CategoryRepositoryAdapter(
    private val repository: CategoryJpaRepository
) : CategoryRepository {

    override fun save(category: Category): Category {
        val entity = CategoryEntity.from(category)
        return this.repository.save(entity).toCategory()
    }

    override fun count(): Long = this.repository.count()

    override fun findAll(): List<Category> = this.repository.findAll().map(CategoryEntity::toCategory).toList()

    override fun findById(categoryId: Long): Optional<Category> = this.repository.findById(categoryId).map(CategoryEntity::toCategory)
}
