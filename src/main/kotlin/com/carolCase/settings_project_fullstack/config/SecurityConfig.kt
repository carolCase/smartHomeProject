package com.carolCase.settings_project_fullstack.config

import com.carolCase.settings_project_fullstack.config.jwt.JwtAuthenticationFilter
import com.carolCase.settings_project_fullstack.model.authority.UserPermission
import com.carolCase.settings_project_fullstack.model.authority.UserRole
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.http.SessionCreationPolicy
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.security.web.SecurityFilterChain
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter


@Configuration
@EnableWebSecurity
class SecurityConfig(
    private val jwtAuthenticationFilter: JwtAuthenticationFilter
) {

    @Bean
    fun passwordEncoder(): PasswordEncoder {
        return BCryptPasswordEncoder()
    }

    @Bean
    fun authenticationManager(authenticationConfiguration: AuthenticationConfiguration): AuthenticationManager {
        return authenticationConfiguration.authenticationManager
    }

    @Bean
    fun securityFilterChain(http: HttpSecurity): SecurityFilterChain {
        http
            .csrf { it.disable() } // Disables CSRF (Cross-Site Request Forgery) protection
            .cors { it.configurationSource { request ->
                // CORS configuration specifically for Spring Security
                org.springframework.web.cors.CorsConfiguration().apply {
                    allowedOrigins = listOf("http://localhost:3000") // Frontend origin
                    allowedMethods = listOf("GET", "POST", "PUT", "DELETE", "PATCH")
                    allowedHeaders = listOf("*")
                    allowCredentials = (true)
                }
            }}
        http
            .formLogin { it
                .permitAll()
              //  .defaultSuccessUrl("/", true)
               // .failureUrl("/login?error=true")
            }
            .logout { it
                .logoutUrl("/logout").permitAll()
            }


            .authorizeHttpRequests { it
              //  .anyRequest().permitAll()
                .requestMatchers("/", "/login", "/logout", "/who-am-i").permitAll()
                .requestMatchers("/users/admin").hasAuthority(UserRole.ADMIN.name)
                .requestMatchers("/users/user").hasRole(UserRole.USER.name)
                .requestMatchers("/users/read").hasAnyAuthority(UserPermission.READ.getContent())
                .anyRequest().authenticated() // Require authentication for all other requests
            }
            .sessionManagement { it.sessionCreationPolicy(SessionCreationPolicy.STATELESS) } // Stateless session
            .addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter::class.java) // Add JWT filter before UsernamePasswordAuthenticationFilter

        return http.build()
    }
}


