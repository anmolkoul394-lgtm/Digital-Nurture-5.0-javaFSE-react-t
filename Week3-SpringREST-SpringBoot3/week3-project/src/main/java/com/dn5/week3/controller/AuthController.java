package com.dn5.week3.controller;

import com.dn5.week3.dto.LoginRequestDTO;
import com.dn5.week3.security.JwtUtil;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * Module 7 -> "Security and Authentication in RESTful APIs" subtopic:
 * a minimal login endpoint that issues a JWT. In a real app the
 * username/password would be checked against a UserDetailsService backed
 * by the database; here it's a hard-coded demo user ("admin"/"admin123")
 * to keep the project self-contained.
 */
@Tag(name = "Auth", description = "Login endpoint that issues a JWT for the protected write endpoints")
@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final JwtUtil jwtUtil;

    public AuthController(JwtUtil jwtUtil) {
        this.jwtUtil = jwtUtil;
    }

    @Operation(summary = "Login and receive a JWT (demo user: admin / admin123)")
    @PostMapping("/login")
    public ResponseEntity<Map<String, String>> login(@Valid @RequestBody LoginRequestDTO request) {
        if ("admin".equals(request.getUsername()) && "admin123".equals(request.getPassword())) {
            String token = jwtUtil.generateToken(request.getUsername());
            return ResponseEntity.ok(Map.of("token", token));
        }
        return ResponseEntity.status(401).body(Map.of("error", "Invalid credentials"));
    }
}
