package me.gabriel.blog.core.ports

import me.gabriel.blog.core.domain.Category
import java.util.*

/**
 * @author daohn
 * @since 20/07/2021
 */
interface CategoryRepository {

    fun save(category: Category): Category
    fun count(): Long
    fun findAll(): List<Category>
    fun findById(categoryId: Long): Optional<Category>

}
