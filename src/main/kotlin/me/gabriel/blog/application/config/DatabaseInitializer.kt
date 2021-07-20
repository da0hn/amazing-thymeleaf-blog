package me.gabriel.blog.application.config

import me.gabriel.blog.core.domain.Category
import me.gabriel.blog.core.domain.User
import me.gabriel.blog.core.ports.CategoryRepository
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
    private val userRepository: UserRepository,
    private val categoryRepository: CategoryRepository
) : CommandLineRunner {

    private val logger: Logger = LoggerFactory.getLogger(javaClass)


    override fun run(vararg args: String?) {

        if (userRepository.count() == 0L) {
            logger.info("Initializing User data")

            val admin = User(
                name = "admin",
                email = "admin@blog.com",
                password = "admin"
            )

            userRepository.save(admin)

            logger.info("User ${admin.name} created successfully")
        }

        if (categoryRepository.count() == 0L) {
            logger.info("Initializing Category data")

            val categories = listOf(
                Category("World"),
                Category("U.S."),
                Category("Technology"),
                Category("Design"),
                Category("Culture"),
                Category("Business"),
                Category("Politics"),
                Category("Opinion"),
                Category("Science"),
                Category("Health"),
                Category("Style"),
                Category("Travel")
            )

            categories.forEach {
                categoryRepository.save(it)
                logger.info("Category ${it.name} created successfully")
            }
        }
    }
}
