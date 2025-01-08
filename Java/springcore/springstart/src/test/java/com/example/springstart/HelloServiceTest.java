package com.example.springstart;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.example.springstart.helloboot.HelloDecorator;
import com.example.springstart.helloboot.SimpleHelloService;
import org.junit.jupiter.api.Test;

public class HelloServiceTest {

    @Test
    void hello() {
        //given
        SimpleHelloService helloService = new SimpleHelloService();
        //when
        String ret = helloService.sayHello("Test");
        //then
        assertEquals(ret, "HelloTest");
    }

    @Test
    void helloDeco() {
        //given
        HelloDecorator decorator = new HelloDecorator(name -> name);
        //when
        String ret = decorator.sayHello("Test");
        //then
        assertEquals(ret, "*Test*");
    }
}
