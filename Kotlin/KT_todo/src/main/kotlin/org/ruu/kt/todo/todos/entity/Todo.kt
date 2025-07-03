package org.ruu.kt.todo.todos.entity

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.EnumType
import jakarta.persistence.Enumerated
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import lombok.Getter
import org.ruu.kt.todo.todos.enum.Priority
import org.ruu.kt.todo.todos.enum.TodoStatus

@Entity
@Getter
class Todo(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private var id : Long,

    @Column(length = 100, nullable = false)
    private var title: String,

    @Column(length = 1000, nullable = true)
    private var content: String? = null,

    @Enumerated(EnumType.STRING)
    private var todoStatus : TodoStatus,

    @Enumerated(EnumType.STRING)
    private var priority: Priority = Priority.MEDIUM,

) : BaseEntity() {

    // 읽기 전용 접근자
    fun getId(): Long = this.id
    fun getTitle(): String = this.title
    fun getContent(): String? = this.content
    fun getTodoStatus(): TodoStatus = this.todoStatus

    // 비즈니스 로직
    fun updateTitle(newTitle: String) {
        require(newTitle.isNotBlank()) { "제목은 비어있을 수 없습니다" }
        this.title = newTitle
    }

    fun updateContent(newContent: String?) {
        this.content = newContent
    }

    fun changeStatus(newStatus: TodoStatus) {
        this.todoStatus = newStatus
    }
}