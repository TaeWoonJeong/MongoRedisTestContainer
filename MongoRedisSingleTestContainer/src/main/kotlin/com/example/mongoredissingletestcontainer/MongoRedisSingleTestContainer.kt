package com.example.mongoredissingletestcontainer

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class MongoRedisSingleTestContainer

fun main(args: Array<String>) {
    runApplication<MongoRedisSingleTestContainer>(*args)
}
