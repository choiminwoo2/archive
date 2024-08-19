package com.example.redisspringboottest;

import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;

@SpringBootApplication
public class RedisSpringBootTestApplication {
//    @Bean
//    CommandLineRunner runner(UserRepository repository){
//        return args -> {
//            UUID uud = UUID.randomUUID();
//            User user = new User(uud,"name");
//            repository.save(user);
//
//        };
//    }

    public static void main(String[] args) {
      SpringApplication.run(RedisSpringBootTestApplication.class, args);
    }

}
