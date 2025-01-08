package com.example.restfulltutorial;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LoadDatabase {

    private static final Logger logger = LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    CommandLineRunner initDatabase(EmployeeRepository repository) {
        return args -> {
            logger.info("Preloading " + repository.save(new Employee("Bob", "manager")));
            logger.info("Preloading " + repository.save(new Employee("Lan", "staff")));
        };
    }

}
