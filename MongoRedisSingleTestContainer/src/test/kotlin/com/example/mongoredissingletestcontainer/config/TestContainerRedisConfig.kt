package com.example.mongoredissingletestcontainer.config

import com.example.mongoredissingletestcontainer.common.CommonDependencyConfig
import org.springframework.context.annotation.Configuration
import org.testcontainers.containers.GenericContainer
import org.testcontainers.junit.jupiter.Container
import org.testcontainers.junit.jupiter.Testcontainers
import org.testcontainers.utility.DockerImageName

@Configuration
@Testcontainers
class TestContainerRedisConfig : CommonDependencyConfig() {
    companion object {
        private const val REDIS_DOCKER_IMAGE = "redis:latest"

        @Container
        val REDIS_CONTAINER = GenericContainer(
            DockerImageName.parse(REDIS_DOCKER_IMAGE)
        ).withExposedPorts(6379)
            .withReuse(true)

        init {
            REDIS_CONTAINER.start()
        }
    }
}
