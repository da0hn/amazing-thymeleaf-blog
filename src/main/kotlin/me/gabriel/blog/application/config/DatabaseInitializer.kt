package me.gabriel.blog.application.config

import me.gabriel.blog.core.domain.*
import me.gabriel.blog.core.ports.ArticleRepository
import me.gabriel.blog.core.ports.CategoryRepository
import me.gabriel.blog.core.ports.UserRepository
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.boot.CommandLineRunner
import org.springframework.context.annotation.Configuration
import java.time.LocalDateTime

/**
 * @author daohn
 * @since 18/07/2021
 */
@Configuration
class DatabaseInitializer(
    private val userRepository: UserRepository,
    private val categoryRepository: CategoryRepository,
    private val articleRepository: ArticleRepository,
) : CommandLineRunner {

    private val logger: Logger = LoggerFactory.getLogger(javaClass)


    override fun run(vararg args: String?) {

        val users = createUsers()

        val authors = createAuthors(users)

        val categories = createCategories()

        val articles = createArticles(authors)
    }

    private fun createArticles(authors: List<Author>): List<Article> {
        if (articleRepository.countArticle() == 0L && authors.isNotEmpty()) {

            logger.info("Initializing Article data")

            val articles = listOf(
                Article(
                    null,
                    "Title 1",
                    "Sub title 1",
                    "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.",
                    LocalDateTime.now(),
                    authors[0]
                ),
                Article(
                    null,
                    "Title 2",
                    "Sub title 2",
                    "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.",
                    LocalDateTime.now(),
                    authors[0]
                ),
                Article(
                    null,
                    "Title 3",
                    "Sub title 3",
                    "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.",
                    LocalDateTime.now(),
                    authors[1]
                ),
            )

            articles.forEach {
                articleRepository.saveArticle(it)
                logger.info("Article ${it.title} created successfully")
            }

            return articles
        }

        return listOf()
    }

    private fun createCategories(): List<Category> {
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

            return categories
        }
        return listOf()
    }

    private fun createUsers(): List<User> {
        if (userRepository.count() == 0L) {
            logger.info("Initializing User data")

            val users = mutableListOf(
                User(
                    name = "admin",
                    email = "admin@blog.com",
                    password = "admin"
                ),
                User(
                    name = "user",
                    email = "user@blog.com",
                    password = "user"
                )
            )

            users.map {
                this.userRepository.save(it)
                logger.info("User ${it.name} created successfully")
            }

            return users
        }
        return listOf()
    }

    private fun createAuthors(users: List<User>): List<Author> {
        if (articleRepository.countAuthor() == 0L && users.isNotEmpty()) {
            val authors = mutableListOf(
                Author(
                    users[0],
                    "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.",
                    SocialNetwork(
                        "https://facebook.com/admin",
                        "https://twitter.com/admin",
                        "https://linkedin.com/admin",
                    )
                ),
                Author(
                    users[1],
                    "Lorem ipsum dolor sit amet, consectetur adipiscing elit",
                    SocialNetwork(
                        "https://facebook.com/user",
                        "https://twitter.com/user",
                        "https://linkedin.com/user",
                    )
                )
            )

            authors.forEach { author ->
                val createdAuthor = articleRepository.saveAuthor(author)
                author.id = createdAuthor.id
                logger.info("Author ${author.user.name} created successfully")
            }

            return authors
        }
        return listOf()
    }
}
