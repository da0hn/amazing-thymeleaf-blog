package me.gabriel.blog.data.database.entities

import javax.persistence.GeneratedValue
import javax.persistence.Id

/**
 * @author daohn
 * @since 16/07/2021
 */
data class UserEntity(
    @Id
    @GeneratedValue
    var id: Long,
    var name: String,
    var email: String,
    var password: String,
)
