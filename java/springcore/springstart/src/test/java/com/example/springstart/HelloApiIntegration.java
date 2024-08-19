package com.example.springstart;


import static org.junit.jupiter.api.Assertions.assertEquals;

import com.example.springstart.helloboot.MySpringApplication;
import com.example.springstart.helloboot.SpringStartApplication;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

@SpringBootTest(classes = MySpringApplication.class)
public class HelloApiIntegration {

    final String BASE_URL = "http://localhost:8080/hello?name={name}";
    TestRestTemplate testRestTemplate = new TestRestTemplate();

    @Test
    void helloApi() {

        ResponseEntity<String> res = testRestTemplate.getForEntity(BASE_URL, String.class, "Spring");

        assertEquals(res.getStatusCode(), HttpStatus.OK);
        assertEquals(res.getHeaders().getFirst(HttpHeaders.CONTENT_TYPE).startsWith(MediaType.TEXT_PLAIN_VALUE), true);
        assertEquals(res.getBody(), "*HelloSpring*");

    }

}
