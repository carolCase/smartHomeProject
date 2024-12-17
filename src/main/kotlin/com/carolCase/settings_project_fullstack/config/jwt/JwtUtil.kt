package com.carolCase.settings_project_fullstack.config.jwt

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.util.Base64;
import java.util.Date;
import java.util.concurrent.TimeUnit;

@Component
class JwtUtil {

    private val base64EncodedSecretKey =
        "U2VjdXJlQXBpX1NlY3JldEtleV9mb3JfSFMyNTYwX3NlY3JldF9wcm9qZWN0X2tleV9leGFtcGxl" // Replace this with your actual base64 encoded secret key
    private final var keyBytes: ByteArray = Base64.getDecoder().decode(base64EncodedSecretKey)

    var key: SecretKey = Keys.hmacShaKeyFor(keyBytes) // This ensures the key is properly named and sized

    // JWT expiration time (1 hour in milliseconds)
    private val jwtExpirationMs = TimeUnit.HOURS.toMillis(1).toInt()

    fun generateJwtToken(username: String?, role: String?): String {
        return Jwts.builder() // TODO - Is the username unique?
            .subject(username) // Set the subject, often the username or user ID
            .claim("role", role)
            .issuedAt(Date()) // Set issued date
            .expiration(Date(System.currentTimeMillis() + jwtExpirationMs)) // Set expiration date
            .signWith(key) // Use the key created for HMAC
            .compact()
    }

    fun getUsernameFromJwtToken(token: String?): String {
        val claims = Jwts.parser()
            .verifyWith(key)
            .build()
            .parseSignedClaims(token)
            .payload

        return claims.subject
    }

    fun getRoleFromJwtToken(token: String?): String {
        val claims = Jwts.parser()
            .verifyWith(key)
            .build()
            .parseSignedClaims(token)
            .payload


        return claims.get("role", String::class.java) // Extract the role from the claims
    }

    fun validateJwtToken(authToken: String?): Boolean {
        try {
            Jwts.parser() // Use parserBuilder() instead of deprecated parser()
                .verifyWith(key) // Provide the signing key for validation
                .build() // Build the JwtParser
                .parseSignedClaims(authToken) // Parse and verify the JWT
            return true // If no exception is thrown, the token is valid
        } catch (e: Exception) {
            // Log token validation errors (like expiration, malformed, etc.)
            System.err.println("Invalid JWT token: " + e.message)
        }
        return false // If an exception is thrown, the token is invalid
    }
}