package com.example.mongoredissingletestcontainer.common

import com.example.mongoredissingletestcontainer.repository.mongodb.UserMongoRepository
import com.example.mongoredissingletestcontainer.repository.redis.UserRedisRepository
import com.example.mongoredissingletestcontainer.service.DBService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class CommonDependencyConfig {
    @Autowired
    lateinit var userRedisRepository: UserRedisRepository

    @Autowired
    lateinit var userMongoRepository: UserMongoRepository

    @Autowired
    lateinit var dbService: DBService
}
