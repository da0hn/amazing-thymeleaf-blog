package me.gabriel.blog.application.config

import me.gabriel.blog.core.domain.User
import me.gabriel.blog.core.ports.UserRepository
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.boot.CommandLineRunner
import org.springframework.context.annotation.Configuration

/**
 * @author daohn
 * @since 18/07/2021
 */
@Configuration
class DatabaseInitializer(
    private val userRepository: UserRepository
) : CommandLineRunner {

    private val logger: Logger = LoggerFactory.getLogger(javaClass)


    override fun run(vararg args: String?) {

        if (userRepository.count() == 0L) {
            logger.info("Initializing database")

            val admin = User(
                name = "admin",
                email = "admin@blog.com",
                password = "admin"
            )

            userRepository.save(admin)

            logger.info("User ${admin.name} created successfully")
        }
    }
}
