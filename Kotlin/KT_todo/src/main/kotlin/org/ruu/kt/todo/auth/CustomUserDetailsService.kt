package org.ruu.kt.todo.auth

import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException

class CustomUserDetailsService(
    private val userRepository : AuthRepository
) : UserDetailsService {

    override fun loadUserByUsername(userId: String): UserDetails {
        val user = userRepository.findByUserId(userId) ?: throw UsernameNotFoundException("User not found")
        return CustomUserDetails(user)
    }
}