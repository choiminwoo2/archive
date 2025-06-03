package org.ruu.kt.todo.auth.service

import org.ruu.kt.todo.auth.AuthRepository
import org.ruu.kt.todo.auth.CustomUserDetails
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.stereotype.Service


open class CustomUserDetailsService(
    private val userRepository : AuthRepository
) : UserDetailsService {

    override fun loadUserByUsername(userId: String): UserDetails {
        val user = userRepository.findByUserId(userId) ?: throw UsernameNotFoundException("User not found")
        return CustomUserDetails(user)
    }
}