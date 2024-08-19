package com.example.springstart.helloboot;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
@Qualifier("simpleHelloService")
public class SimpleHelloService implements HelloService {

    @Override
    public String sayHello(String name) {

        return "Hello" + name;
    }

}
