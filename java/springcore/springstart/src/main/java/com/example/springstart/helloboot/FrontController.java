package com.example.springstart.helloboot;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/hello")
public class FrontController {

    private final HelloService helloService;

    public FrontController(@Qualifier("helloDecorator") HelloService helloService) {

        this.helloService = helloService;
    }

    @GetMapping
    @ResponseBody
    public String hello(@RequestParam(value = "name") String name) {

        return helloService.sayHello(name);
    }

}
