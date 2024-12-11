package org.ruu.bootthymeleafjpa.controller;

import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Log4j2
@RequestMapping("/api")
public class SampleRestController {

    @GetMapping("/helloJson")
    public String[] helloJson(){

        log.info("helloJson....");

        return new String[]{"AAA","BBB","CCC"};
    }

}
