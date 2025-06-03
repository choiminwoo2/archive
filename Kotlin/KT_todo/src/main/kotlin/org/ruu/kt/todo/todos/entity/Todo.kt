package org.ruu.kt.todo.todos.entity

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import lombok.Getter

@Entity
@Getter
class Todo(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id : Long,

    @Column(length = 100, nullable = false)
    var title: String,

    @Column(length = 1000, nullable = true)
    var content: String? = null

) : BaseEntity() {

    fun addContent(content: String) {
        this.content = content
    }
}