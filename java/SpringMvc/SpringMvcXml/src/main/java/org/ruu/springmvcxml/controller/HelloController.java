package org.ruu.springmvcxml.controller;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@Log4j2
public class HelloController {

    @GetMapping("/hello")
    public void hello(){
        log.info("hello");
    }
}
