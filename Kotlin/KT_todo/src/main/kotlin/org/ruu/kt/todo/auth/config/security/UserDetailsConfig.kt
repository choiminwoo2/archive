package org.ruu.kt.todo.auth.config.security

import org.ruu.kt.todo.auth.AuthRepository
import org.ruu.kt.todo.auth.service.CompositeUserDetailsService
import org.ruu.kt.todo.auth.service.CustomUserDetailsService
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.core.userdetails.User
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.security.provisioning.InMemoryUserDetailsManager

@Configuration
class UserDetailsConfig {

    @Bean
    fun userDetailsService(
         passwordEncoder: PasswordEncoder,
         userRepository: AuthRepository
    ): UserDetailsService {

        // 인메모리 테스트용 계정 생성
        val testUser1: UserDetails = User.withUsername("test1")
            .password(passwordEncoder.encode("test1"))
            .roles("USER")
            .build()

        val testUser2: UserDetails = User.withUsername("test2")
            .password(passwordEncoder.encode("test2"))
            .roles("USER")
            .build()

        val inMemoryManager = InMemoryUserDetailsManager(testUser1, testUser2)

        val customService = CustomUserDetailsService(userRepository)

        return CompositeUserDetailsService(customService, inMemoryManager)
    }
}