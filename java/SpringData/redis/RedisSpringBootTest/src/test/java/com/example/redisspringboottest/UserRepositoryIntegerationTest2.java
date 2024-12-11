package com.example.redisspringboottest;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class UserRepositoryIntegerationTest2 {

    @Autowired
    private UserRepository userRepository;

    @Test
    @DisplayName("멤버 저장 확인")
    void shouldSaveUser_toRedis(){
        UUID uuid = UUID.randomUUID();
        User user = new User(uuid, "name");
        User saved = userRepository.save(user);
        assertNotNull(saved);

        User user1 = userRepository.findAll().iterator().next();
        assertNotNull(user1);
    }
}
