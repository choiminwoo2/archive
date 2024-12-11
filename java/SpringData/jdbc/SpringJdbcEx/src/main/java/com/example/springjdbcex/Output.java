package com.example.springjdbcex;

import lombok.experimental.UtilityClass;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@UtilityClass
public class Output {

    private final Logger LOG = LoggerFactory.getLogger(Output.class);

    public static void list(Iterable<?> categories, String title) {

        var message = new StringBuilder(String.format("==== %s ====\n", title));

        categories.forEach(category -> message.append(category.toString().replace(", ", ",\n\t")));

        LOG.info(message.toString());
    }
}