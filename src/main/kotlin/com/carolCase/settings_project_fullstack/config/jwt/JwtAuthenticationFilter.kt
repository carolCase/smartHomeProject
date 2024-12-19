package com.carolCase.settings_project_fullstack.config.jwt

import com.carolCase.settings_project_fullstack.model.CustomUserDetailsService
import io.jsonwebtoken.Jwts
import io.micrometer.common.lang.NonNull
import jakarta.servlet.FilterChain
import jakarta.servlet.ServletException
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpHeaders
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.stereotype.Component
import org.springframework.web.filter.OncePerRequestFilter
import java.io.IOException

@Component
class JwtAuthenticationFilter @Autowired constructor(
    private val jwtUtils: JwtUtil,
    private val customUserDetailsService: CustomUserDetailsService
): OncePerRequestFilter() {

    @Throws(ServletException::class, IOException::class)
    override fun doFilterInternal(
        @NonNull request: HttpServletRequest,
        @NonNull response: HttpServletResponse,
        @NonNull filterChain: FilterChain
    ) {
        println("---JwtAuthenticationFilter---")
        println("---START---")
        println("EXTRACTING FROM REQUEST")
        var token: String? = extractJwtFromCookie(request)
        if (token == null){
            token = extractJwtFromRequest(request)
        }
        println("TOKEN: $token")
        println("---END---")

        if (token != null && jwtUtils.validateJwtToken(token)) {
            val username: String = jwtUtils.getUsernameFromJwtToken(token)
            val userDetails = customUserDetailsService.loadUserByUsername(username)

            val authenticationToken = UsernamePasswordAuthenticationToken(
                userDetails,
                null,
                userDetails.authorities
            )

            SecurityContextHolder.getContext().authentication = authenticationToken
        }

        filterChain.doFilter(request, response)
    }

    private fun extractJwtFromCookie(request: HttpServletRequest): String? {
        // Extract JWT from cookies
        val cookies = request.cookies
        if (cookies != null) {
            for (cookie in cookies) {
                if ("authToken" == cookie.name) {
                    return cookie.value // Return the token if found
                }
            }
        }
        return null
    }


    private fun extractJwtFromRequest(request: HttpServletRequest): String? {
        val header = request.getHeader(HttpHeaders.AUTHORIZATION)
        if (header != null && header.startsWith("Bearer")) {
            return header.substring(7) // Extract the token part after "Bearer "
        }
        return null
    }
}



