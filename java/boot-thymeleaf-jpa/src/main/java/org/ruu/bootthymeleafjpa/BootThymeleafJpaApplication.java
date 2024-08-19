package org.ruu.bootthymeleafjpa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@EnableJpaAuditing
public class BootThymeleafJpaApplication {

    public static void main(String[] args) {

        SpringApplication.run(BootThymeleafJpaApplication.class, args);
    }

}
