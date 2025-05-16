package com.carolCase.settings_project_fullstack.config.jwt

import com.carolCase.settings_project_fullstack.model.services.HouseUserDetailsService
import jakarta.servlet.FilterChain
import jakarta.servlet.ServletException
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.stereotype.Component
import org.springframework.web.filter.OncePerRequestFilter
import java.io.IOException

@Component
class JwtAuthenticationFilter @Autowired constructor(
    private val jwtUtils: JwtUtil,
    private val houseUserDetailsService: HouseUserDetailsService
) : OncePerRequestFilter() {

    @Throws(ServletException::class, IOException::class)
    override fun doFilterInternal(
        request: HttpServletRequest,
        response: HttpServletResponse,
        filterChain: FilterChain
    ) {
        // Skip authentication for the /register endpoint
        if (request.requestURI.startsWith("/register")) {
            filterChain.doFilter(request, response)
            return
        }

        println("---JwtAuthenticationFilter---")
        println("---START---")
        println("EXTRACTING FROM REQUEST")

        val authHeader = request.getHeader("Authorization")
        val token = authHeader?.takeIf { it.startsWith("Bearer ") }?.removePrefix("Bearer ")


        if (token != null && jwtUtils.validateJwtToken(token)) {
            // If the token is valid, extract the username and load user details
            val username: String = jwtUtils.getUsernameFromJwtToken(token)
            val userDetails = houseUserDetailsService.loadUserByUsername(username)

            // Create an authentication token and set it in the SecurityContext
            val authenticationToken = UsernamePasswordAuthenticationToken(
                userDetails,
                null,
                userDetails.authorities
            )
            SecurityContextHolder.getContext().authentication = authenticationToken
        }

        filterChain.doFilter(request, response)
    }


}
