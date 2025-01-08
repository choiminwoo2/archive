package com.example.redisspringboottest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RedisProperties {

    private int redisPort;
    private String redisHost;

    public RedisProperties(
            @Value("${spring.data.redis.port}") int redisPort,
            @Value("${spring.data.redis.host}") String redisHost) {
        this.redisHost = redisHost;
        this.redisPort = redisPort;
    }

    public int getRedisPort() {
        return redisPort;
    }

    public String getRedisHost() {
        return redisHost;
    }
}
