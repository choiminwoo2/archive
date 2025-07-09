package org.ruu.kt.todo.todos.dto

import org.ruu.kt.todo.todos.enum.Priority
import org.ruu.kt.todo.todos.enum.TodoStatus

data class TodoDTO(
    val id: Long? = null,
    val title: String,
    val content: String? = null,
    val todoStatus: TodoStatus,
    val priority: Priority = Priority.MEDIUM
)