package com.carolCase.settings_project_fullstack.config.cors

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.cors.CorsConfiguration
import org.springframework.web.cors.CorsConfigurationSource
import org.springframework.web.cors.UrlBasedCorsConfigurationSource


@Configuration
class CorsConfig {
    @Configuration
    class CorsConfig {
        @Bean
        fun corsConfigurationSource(): CorsConfigurationSource {
            val corsConfiguration = CorsConfiguration()

            // Allow requests from frontend URL
            corsConfiguration.allowedOrigins = listOf("http://localhost:3000")
            corsConfiguration.allowedMethods = listOf("GET", "POST", "DELETE", "PUT", "PATCH")
            corsConfiguration.allowedHeaders = listOf("Content-Type", "Authorization", "X-Requested-With")
            corsConfiguration.allowCredentials = true

            val source = UrlBasedCorsConfigurationSource()

            // Register cors for all endpoints
            source.registerCorsConfiguration("/**", corsConfiguration)

            return source
        }
    }


}
