package com.carolCase.settings_project_fullstack.config

import com.carolCase.settings_project_fullstack.config.jwt.JwtAuthenticationFilter
import com.carolCase.settings_project_fullstack.model.CustomUser
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.Customizer
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configurers.CorsConfigurer
import org.springframework.security.config.http.SessionCreationPolicy
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.security.web.SecurityFilterChain
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter

@Configuration
@EnableWebSecurity
class SecurityConfig @Autowired constructor(
    val passwordEncoder: PasswordEncoder,
    val jwtAuthenticationFilter: JwtAuthenticationFilter
    // TODO  val customUserDetailsService: CustomUserDetailsService,
) {


    @Bean
    fun passwordEncoder(): PasswordEncoder {
        return BCryptPasswordEncoder()
    }



    @Bean
    fun securityFilterChain(http: HttpSecurity): SecurityFilterChain {
        http
            .csrf { it.disable() }
            .cors { Customizer.withDefaults<CorsConfigurer<HttpSecurity>>() }
            .authorizeHttpRequests { it
                .requestMatchers("/", "/login", "/logout", "/user", "/user/password", "/who-am-i").permitAll()
             //   .requestMatchers("/user/admin").hasRole(ADMIN.name) // UserRole.ADMIN.name
              //  .requestMatchers("/user/user").hasRole(USER.name)
              //  .requestMatchers("/user/read").hasAnyAuthority(UserPermission.READ.getContent())
                .anyRequest().authenticated() // Must Log In
            }

            // .authenticationProvider(customDaoAuthenticationProvider())
            .sessionManagement { it.sessionCreationPolicy(SessionCreationPolicy.STATELESS) }
            .addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter::class.java) // on each request

        return http.build()
    }
}
