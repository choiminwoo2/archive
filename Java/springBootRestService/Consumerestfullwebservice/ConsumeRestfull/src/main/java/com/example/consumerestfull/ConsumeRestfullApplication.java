package com.example.consumerestfull;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.web.client.RestTemplate;

record Value(long id, String quote){

}

record Quote(String type, Value value){}

@SpringBootApplication
public class ConsumeRestfullApplication {
    Logger logger = LoggerFactory.getLogger(ConsumeRestfullApplication.class);

    @Bean
    @Profile("!test")
    CommandLineRunner run(RestTemplate restTemplate){
        return args -> {
        Quote quote = restTemplate.getForObject("http://localhost:8080/api/random", Quote.class);
        logger.info(quote.toString());
        };
    }
    @Bean
    RestTemplate restTemplate(RestTemplateBuilder builder){
        return builder.build();
    }

    public static void main(String[] args) {
        SpringApplication.run(ConsumeRestfullApplication.class, args);
    }

}
