package com.example.springjdbcex;

import java.time.LocalDateTime;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Setter;
import lombok.With;

import org.springframework.data.annotation.Id;

public class Category {

    private final @Id Long id;
    private String name, description;
    private LocalDateTime created;
    private @Setter long inserted;
    private AgeGroup ageGroup;

    public Category(String name, String description, AgeGroup ageGroup) {

        this.id = null;
        this.name = name;
        this.description = description;
        this.ageGroup = ageGroup;
        this.created = LocalDateTime.now();
    }

    public void timeStamp() {

        if (inserted == 0) {
            inserted = System.currentTimeMillis();
        }
    }
}