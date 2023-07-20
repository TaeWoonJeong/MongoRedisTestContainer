package com.example.mongoredissingletestcontainer.service

import com.example.mongoredissingletestcontainer.model.mongodb.MongoUser
import com.example.mongoredissingletestcontainer.model.redis.RedisUser
import com.example.mongoredissingletestcontainer.repository.mongodb.UserMongoRepository
import com.example.mongoredissingletestcontainer.repository.redis.UserRedisRepository
import org.springframework.stereotype.Service
import java.util.UUID

@Service
class DBService(
    private val userRedisRepository: UserRedisRepository,
    private val userMongoRepository: UserMongoRepository
) {
    fun getRedis(): List<RedisUser> {
        return userRedisRepository.findAll()
    }

    fun addRedis(email: String, name: String) {
        userRedisRepository.save(
            RedisUser(
                id = UUID.randomUUID().toString(),
                email = email,
                name = name
            )
        )
    }

    fun getMongo(): List<MongoUser> {
        return userMongoRepository.findAll()
    }

    fun addMongo(email: String, name: String) {
        userMongoRepository.save(
            MongoUser(
                id = UUID.randomUUID().toString(),
                email = email,
                name = name
            )
        )
    }
}
