package org.ruu.kt.todo

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.data.jpa.repository.config.EnableJpaAuditing

@SpringBootApplication
@EnableJpaAuditing
class KtTodoApplication

fun main(args: Array<String>) {
    runApplication<KtTodoApplication>(*args)
}
