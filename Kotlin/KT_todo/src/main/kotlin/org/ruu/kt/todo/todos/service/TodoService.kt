package org.ruu.kt.todo.todos.service

import org.ruu.kt.todo.todos.dto.TodoDTO
import org.ruu.kt.todo.todos.repository.TodoRepository
import org.springframework.stereotype.Service

@Service
class TodoService(
    private val todoRepository: TodoRepository
) {

    fun getTodosByUserId( userId : String ) : List<TodoDTO>{
        //리스트화
        return mutableListOf();
    }

}