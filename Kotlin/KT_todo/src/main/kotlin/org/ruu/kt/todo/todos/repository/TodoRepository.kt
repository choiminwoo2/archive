package org.ruu.kt.todo.todos.repository

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
class TodoRepository : JpaRepository<Todo, Long>{
}