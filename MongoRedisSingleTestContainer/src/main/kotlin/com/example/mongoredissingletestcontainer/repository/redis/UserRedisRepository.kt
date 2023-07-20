package com.example.mongoredissingletestcontainer.repository.redis

import com.example.mongoredissingletestcontainer.model.redis.RedisUser
import org.springframework.data.repository.CrudRepository

interface UserRedisRepository : CrudRepository<RedisUser, String> {
    override fun findAll(): List<RedisUser>
}
