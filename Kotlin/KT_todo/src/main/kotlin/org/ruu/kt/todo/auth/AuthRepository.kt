package org.ruu.kt.todo.auth

import org.springframework.data.jpa.repository.JpaRepository

interface AuthRepository : JpaRepository<User, String> {
    fun findByUserId(userId: String): User?
}