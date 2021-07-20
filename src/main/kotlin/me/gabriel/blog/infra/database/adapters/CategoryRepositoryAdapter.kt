package me.gabriel.blog.infra.database.adapters

import me.gabriel.blog.core.domain.Category
import me.gabriel.blog.core.ports.CategoryRepository
import me.gabriel.blog.infra.database.entities.CategoryEntity
import me.gabriel.blog.infra.database.repositories.CategoryJpaRepository
import org.springframework.stereotype.Component

/**
 * @author daohn
 * @since 20/07/2021
 */
@Component
class CategoryRepositoryAdapter(
    private val repository: CategoryJpaRepository
) : CategoryRepository {

    override fun save(category: Category) {
        val entity = CategoryEntity.from(category)
        this.repository.save(entity)
    }

    override fun count(): Long = this.repository.count()
}
