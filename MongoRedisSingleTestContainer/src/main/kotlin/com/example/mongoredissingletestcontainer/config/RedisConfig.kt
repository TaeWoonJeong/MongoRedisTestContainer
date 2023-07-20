package com.example.mongoredissingletestcontainer.config

import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory
import org.springframework.data.redis.core.StringRedisTemplate
import org.springframework.data.redis.repository.configuration.EnableRedisRepositories
import org.springframework.data.redis.serializer.StringRedisSerializer

//RedisConfig 파일이 없으면 localhost:6379로 자동 설정
//여기서 @Value 어노테이션 사용으로 test 에서 application.yml 에 redis_host 와 redis_port 추가해줘야함
@Configuration
@EnableRedisRepositories
class RedisConfig(
    @Value("\${spring.data.redis.host}")
    private val redisHost: String,
    @Value("\${spring.data.redis.port}")
    private val redisPort: Int
) {
    @Bean
    fun redisConnectionFactory() = LettuceConnectionFactory(redisHost, redisPort)
}
