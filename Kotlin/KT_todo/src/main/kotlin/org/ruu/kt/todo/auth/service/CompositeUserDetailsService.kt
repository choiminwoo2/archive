package org.ruu.kt.todo.auth.service

import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.security.provisioning.InMemoryUserDetailsManager



class CompositeUserDetailsService(
    private val customUserDetailsService :CustomUserDetailsService,
    private val inMemoryUserDetailsService: InMemoryUserDetailsManager
) : UserDetailsService {

    override fun loadUserByUsername(username: String): UserDetails {
        return try {
            inMemoryUserDetailsService.loadUserByUsername(username)
        } catch (ex: UsernameNotFoundException) {
            customUserDetailsService.loadUserByUsername(username)
        }
    }



}