package me.gabriel.blog.infra.logger.adapters

import me.gabriel.blog.core.ports.Logger
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Component

/**
 * @author daohn
 * @since 28/08/2021
 */
@Component
class Slf4jLoggerAdapter<T>(javaClazz: Class<T>) : Logger {

    private var logger: org.slf4j.Logger

    init {
        logger = LoggerFactory.getLogger(javaClazz)
    }

    override fun info(message: String) {
        logger.info(message)
    }
}
