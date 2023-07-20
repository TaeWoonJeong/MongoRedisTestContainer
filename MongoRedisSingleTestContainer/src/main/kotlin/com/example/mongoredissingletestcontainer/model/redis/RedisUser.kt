package com.example.mongoredissingletestcontainer.model.redis

import org.springframework.data.annotation.Id
import org.springframework.data.redis.core.RedisHash

@RedisHash("users")
class RedisUser(
    @Id
    val id: String, // UUID
    val email: String,
    val name: String
)
