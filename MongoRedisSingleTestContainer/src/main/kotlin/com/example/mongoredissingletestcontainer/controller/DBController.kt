package com.example.mongoredissingletestcontainer.controller

import com.example.mongoredissingletestcontainer.model.mongodb.MongoUser
import com.example.mongoredissingletestcontainer.model.redis.RedisUser
import com.example.mongoredissingletestcontainer.request.AddUserRequest
import com.example.mongoredissingletestcontainer.service.DBService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class DBController(private val dbService: DBService) {
    @GetMapping("/redis")
    fun getRedis(): List<RedisUser> {
        return dbService.getRedis()
    }

    @PostMapping("/redis")
    fun addRedis(@RequestBody addUserRequest: AddUserRequest) {
        return dbService.addRedis(addUserRequest.email, addUserRequest.name)
    }

    @GetMapping("/mongo")
    fun getMongo(): List<MongoUser> {
        return dbService.getMongo()
    }

    @PostMapping("/mongo")
    fun addMongo(@RequestBody addUserRequest: AddUserRequest) {
        return dbService.addMongo(addUserRequest.email, addUserRequest.name)
    }
}
