package me.gabriel.blog.core.ports

import me.gabriel.blog.core.domain.Category

/**
 * @author daohn
 * @since 20/07/2021
 */
interface CategoryRepository {

    fun save(category: Category)
    fun count(): Long
    fun findAll(): List<Category>

}
