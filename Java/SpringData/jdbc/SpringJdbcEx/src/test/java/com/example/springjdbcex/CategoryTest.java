package com.example.springjdbcex;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureJdbc;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = CategoryConfiguration.class)
@AutoConfigureJdbc
public class CategoryTest {

    @Autowired
    CategoryRepository categoryRepository;

    @Test
    void saveTest(){
        var cars = categoryRepository.save(new Category("Cars", "Anything that has approximately 4 wheels.", AgeGroup._3to8));
        var buildings = categoryRepository.save(new Category("Buildings", null, AgeGroup._12andOlder));

        Output.list(categoryRepository.findAll(), "`Cars` and `Buildings` got saved");



    }
}
