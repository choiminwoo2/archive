package com.example.redisspringboottest;


import java.io.Serializable;
import java.util.UUID;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

@RedisHash("user")
public class User {
    @Id
    UUID uuid;
    String name;

    public User(UUID uuid, String name) {
        this.uuid = uuid;
        this.name = name;
    }
}
