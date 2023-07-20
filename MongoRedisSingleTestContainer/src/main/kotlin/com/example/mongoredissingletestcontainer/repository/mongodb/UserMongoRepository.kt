package com.example.mongoredissingletestcontainer.repository.mongodb

import com.example.mongoredissingletestcontainer.model.mongodb.MongoUser
import org.springframework.data.mongodb.repository.MongoRepository

interface UserMongoRepository : MongoRepository<MongoUser, String>
