package com.example.redisspringboottest;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import org.springframework.boot.test.context.TestConfiguration;
import redis.embedded.RedisExecProvider;
import redis.embedded.RedisServer;
import redis.embedded.util.Architecture;
import redis.embedded.util.OS;

//@TestConfiguration
public class TestRedisConfiguration {

    private static RedisServer redisServer;

    public TestRedisConfiguration(RedisProperties redisProperties)  {
        this.redisServer = new RedisServer(/*
        운영 체제별 RedisExecProvider로 설정할 수 있다.
        getRedisPath()
         */redisProperties.getRedisPort());
    }

//    private RedisExecProvider getRedisPath() {
//        RedisExecProvider customProvider = null;
//        customProvider = RedisExecProvider.defaultProvider()
//                .override(OS.UNIX, "/path/unix/redis")
//                .override(OS.WINDOWS, Architecture.x86_64, "C:/Redis")
//                .override(OS.MAC_OS_X, Architecture.x86_64, "/path/macosx/redis");
//
//        return customProvider;
//    }

    @PostConstruct
    public void redisServer() {
        redisServer.start();
    }

    @PreDestroy
    public void stopServer() {
        redisServer.stop();
    }


}
