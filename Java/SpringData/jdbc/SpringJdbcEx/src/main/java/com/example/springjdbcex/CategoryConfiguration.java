package com.example.springjdbcex;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jdbc.repository.config.AbstractJdbcConfiguration;
import org.springframework.data.jdbc.repository.config.EnableJdbcRepositories;
import org.springframework.data.relational.core.mapping.event.BeforeSaveCallback;
import org.springframework.data.relational.core.mapping.event.RelationalEvent;

@Configuration
@EnableJdbcRepositories
public class CategoryConfiguration extends AbstractJdbcConfiguration {


    @Bean
    public ApplicationListener<?> loggingListener() {

        return (ApplicationListener<ApplicationEvent>) event -> {
            if (event instanceof RelationalEvent) {
                System.out.println("Received an event: " + event);
            }
        };
    }

    @Bean
    public BeforeSaveCallback<Category> timeStampingSaveTime() {

        return (entity, aggregateChange) -> {

            entity.timeStamp();

            return entity;
        };
    }
}
