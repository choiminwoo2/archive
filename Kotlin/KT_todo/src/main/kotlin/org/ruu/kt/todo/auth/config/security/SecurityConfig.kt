package org.ruu.kt.todo.auth.config.security

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Profile
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.config.Customizer
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.security.web.SecurityFilterChain

@Configuration
@EnableWebSecurity
@Profile("local")
class SecurityConfig{

        @Bean
        fun securityFilterChain(http: HttpSecurity): SecurityFilterChain {
            return http
                .csrf { csrf ->
                    csrf.disable()
                }
                .headers { headers ->
                    headers.frameOptions { it.disable() }
                }
                .authorizeHttpRequests { auth ->
                    auth.requestMatchers("/h2-console/**").permitAll()
                        .requestMatchers("/todos/**").authenticated()
                        .anyRequest().permitAll()
                }
                .formLogin { }
                .httpBasic(Customizer.withDefaults())
                .build()
        }

    // 6.1 버전부터 해당 방식으로 변경됨.
    // authenticationConfiguration 은 PasswordEncoder와 UserDetailService를 제공함.
    @Bean
    fun authenticationManager(authenticationConfiguration: AuthenticationConfiguration): AuthenticationManager {
        return authenticationConfiguration.authenticationManager
    }

    @Bean
    fun passwordEncoder(): PasswordEncoder {
        return BCryptPasswordEncoder()
    }



}