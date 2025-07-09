package org.ruu.kt.todo.todos.mapper

import org.ruu.kt.todo.todos.dto.TodoDTO
import org.ruu.kt.todo.todos.entity.Todo

fun Todo.toDTO(): TodoDTO = TodoDTO(
    id = this.getId(),
    title = this.getTitle(),
    content = this.getContent(),
    todoStatus = this.getTodoStatus(),
    priority = this.getPriority()
)

fun TodoDTO.toEntity(): Todo = Todo(
    id = this.id ?: -7L, //  nullable 회피용 디폴트값
    title = this.title,
    content = this.content,
    todoStatus = this.todoStatus,
    priority = this.priority
)