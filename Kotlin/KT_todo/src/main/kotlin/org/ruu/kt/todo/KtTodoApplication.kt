package org.ruu.kt.todo

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class KtTodoApplication

fun main(args: Array<String>) {
    runApplication<KtTodoApplication>(*args)
}
