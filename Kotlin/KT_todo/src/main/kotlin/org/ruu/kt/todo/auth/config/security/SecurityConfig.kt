package org.ruu.kt.todo.auth.config.security

import org.ruu.kt.todo.auth.CustomUserDetails
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.config.Customizer
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.web.SecurityFilterChain

@Configuration
@EnableWebSecurity
class SecurityConfig {

    private val customUserDetailsService : CustomUserDetails

    @Bean
    fun securityFilterChain(http: HttpSecurity): SecurityFilterChain {
        http
            .csrf { it.disable() }
            .authorizeHttpRequests {
                it.requestMatchers("/todos/**").authenticated()
                    .anyRequest().permitAll()
            }
            .formLogin { it.disable() }
            .httpBasic(Customizer.withDefaults())

        return http.build()
    }

    @Bean
    fun authticationManager(http: HttpSecurity) : AuthenticationManager {
        return http.getSharedObject(AuthenticationManagerBuilder::class.java)
            .userDetailsService(cu)
    }

}