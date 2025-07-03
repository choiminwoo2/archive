package org.ruu.kt.todo.todos.enum

enum class TodoStatus(
    val value: String
) {

    PENDING("진행 중"),
    COMPLETED("완료"),
    CANCELLED("취소");


}