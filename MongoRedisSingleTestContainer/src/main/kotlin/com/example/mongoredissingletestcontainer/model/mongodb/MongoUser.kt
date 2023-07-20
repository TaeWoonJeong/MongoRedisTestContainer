package com.example.mongoredissingletestcontainer.model.mongodb

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document(collection = "users")
class MongoUser(
    @Id
    val id: String, // UUID
    val email: String,
    val name: String
)
