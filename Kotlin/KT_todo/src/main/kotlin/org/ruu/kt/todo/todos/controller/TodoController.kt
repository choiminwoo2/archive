package org.ruu.kt.todo.todos.controller

import org.ruu.kt.todo.todos.dto.TodoDTO
import org.ruu.kt.todo.todos.service.TodoService
import org.springframework.security.core.annotation.AuthenticationPrincipal
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import java.security.Principal

@RestController
@RequestMapping("/todos")
class TodoController(
    private val todoService: TodoService
) {




    @GetMapping()
    fun getTodo(
        @RequestParam(value = "page", defaultValue = "0") page: Int,
        @RequestParam(value = "pageSize", defaultValue = "10") pageSize: Int,
        @AuthenticationPrincipal userDetails: UserDetails,
    ) : List<TodoDTO> {

        val todosByUserName: List<TodoDTO> = todoService.getTodosByUserName(userDetails.username);

        return todosByUserName;

    }
}