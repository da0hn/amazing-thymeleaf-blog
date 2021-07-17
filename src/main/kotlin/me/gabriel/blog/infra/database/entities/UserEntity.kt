package me.gabriel.blog.infra.database.entities

import me.gabriel.blog.core.domain.User
import org.hibernate.Hibernate
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

/**
 * @author daohn
 * @since 16/07/2021
 */
@Entity
data class UserEntity(
    @Id
    @GeneratedValue
    var id: Long? = null,
    var name: String,
    var email: String,
    var password: String,
) {
    companion object {
        fun from(user: User): UserEntity {
            return UserEntity(
                name = user.name,
                email = user.email,
                password = user.password,
            )
        }
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || Hibernate.getClass(this) != Hibernate.getClass(other)) return false
        other as UserEntity

        return id != null && id == other.id
    }

    override fun hashCode(): Int = 1838525018

    @Override
    override fun toString(): String {
        return this::class.simpleName + "(id = $id , name = $name , email = $email , password = $password )"
    }
}
