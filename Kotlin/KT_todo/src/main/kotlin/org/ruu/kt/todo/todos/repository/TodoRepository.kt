package org.ruu.kt.todo.todos.repository

import org.ruu.kt.todo.todos.entity.Todo
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface TodoRepository : JpaRepository<Todo, Long>{
}