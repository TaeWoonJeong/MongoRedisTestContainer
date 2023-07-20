package com.example.mongoredissingletestcontainer.redis

import com.example.mongoredissingletestcontainer.config.TestContainerRedisConfig
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.springframework.test.context.DynamicPropertyRegistry
import org.springframework.test.context.DynamicPropertySource

class AddRedisTest : TestContainerRedisConfig() {
    companion object {
        @JvmStatic
        @DynamicPropertySource
        fun overrideProps(registry: DynamicPropertyRegistry) {
            registry.add("spring.data.redis.host") { REDIS_CONTAINER.host }
            registry.add("spring.data.redis.port") { REDIS_CONTAINER.firstMappedPort }
        }
    }

    @BeforeEach
    fun setup() {
        val address: String = REDIS_CONTAINER.host
        val port: Int = REDIS_CONTAINER.firstMappedPort
        println(address + port + "입니다.")
    }

    @Test
    fun addRedisTest() {
        dbService.addRedis("email", "name")
        val redis = dbService.getRedis()
        Assertions.assertEquals(redis.size, 1)
    }
}
