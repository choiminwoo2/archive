package org.ruu.kt.todo.config

import org.springframework.boot.info.BuildProperties
import org.springframework.boot.test.context.TestConfiguration
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Import
import org.springframework.context.annotation.Primary
import java.util.Properties

@Retention(AnnotationRetention.RUNTIME)
@Target(AnnotationTarget.CLASS)
@Import(TestBuildConfiguration::class)
annotation class RestDocTest

@TestConfiguration
class TestBuildConfiguration {

    @Bean
    @Primary
    fun buildProperties(): BuildProperties {
        val properties = Properties()
        properties.setProperty("version", "1.0.0-TEST")
        properties.setProperty("name", "test-app")
        return BuildProperties(properties)
    }
}
