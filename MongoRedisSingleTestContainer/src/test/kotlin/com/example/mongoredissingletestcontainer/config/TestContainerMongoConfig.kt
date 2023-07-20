package com.example.mongoredissingletestcontainer.config

import com.example.mongoredissingletestcontainer.common.CommonDependencyConfig
import org.springframework.context.annotation.Configuration
import org.testcontainers.containers.GenericContainer
import org.testcontainers.junit.jupiter.Container
import org.testcontainers.junit.jupiter.Testcontainers
import org.testcontainers.utility.DockerImageName

@Configuration
@Testcontainers
class TestContainerMongoConfig : CommonDependencyConfig() {
    companion object {
        private const val MONGO_DOCKER_IMAGE = "mongo:latest"

        @JvmStatic
        @Container
        val MONGO_CONTAINER = GenericContainer(
            DockerImageName.parse(MONGO_DOCKER_IMAGE)
        ).withExposedPorts(27017)
            .withReuse(true)

        init {
            MONGO_CONTAINER.start()
        }
    }
}
