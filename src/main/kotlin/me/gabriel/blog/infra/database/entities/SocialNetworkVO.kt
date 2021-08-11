package me.gabriel.blog.infra.database.entities

import me.gabriel.blog.core.domain.SocialNetwork
import javax.persistence.Embeddable

/**
 * @author daohn
 * @since 11/08/2021
 */
@Embeddable
data class SocialNetworkVO(
    private val facebook: String,
    private val twitter: String,
    private val linkedIn: String
) {
    companion object {
        fun from(socialNetwork: SocialNetwork): SocialNetworkVO {
            return SocialNetworkVO(
                socialNetwork.facebook,
                socialNetwork.twitter,
                socialNetwork.linkedIn
            )
        }
    }

    fun toSocialNetwork(): SocialNetwork {
        return SocialNetwork(
            facebook,
            twitter,
            linkedIn
        )
    }
}
