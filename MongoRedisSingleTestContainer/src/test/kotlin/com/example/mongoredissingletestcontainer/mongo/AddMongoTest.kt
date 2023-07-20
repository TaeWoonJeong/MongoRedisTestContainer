package com.example.mongoredissingletestcontainer.mongo

import com.example.mongoredissingletestcontainer.config.TestContainerMongoConfig
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.springframework.test.context.DynamicPropertyRegistry
import org.springframework.test.context.DynamicPropertySource

class AddMongoTest : TestContainerMongoConfig() {
    companion object {
        @JvmStatic
        @DynamicPropertySource
        fun overrideProps(registry: DynamicPropertyRegistry) {
            registry.add("spring.data.mongodb.host") { MONGO_CONTAINER.host }
            registry.add("spring.data.mongodb.port") { MONGO_CONTAINER.firstMappedPort.toString() }
        }
    }

    @BeforeEach
    fun setup() {
        val address: String = MONGO_CONTAINER.host
        val port: Int = MONGO_CONTAINER.firstMappedPort
        println(address + port + "입니다.")
    }

    @Test
    fun addMongoTest() {
        dbService.addMongo("email", "name")
        val mongo = dbService.getMongo()
        Assertions.assertEquals(mongo.size, 1)
    }
}
