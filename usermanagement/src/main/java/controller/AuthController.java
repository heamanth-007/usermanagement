package com.example.usermanagement.controller;

import lombok.Data;
import org.springframework.web.bind.annotation.*;
import com.example.usermanagement.security.JwtUtil;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final JwtUtil jwtUtil;

    public AuthController(JwtUtil jwtUtil) {
        this.jwtUtil = jwtUtil;
    }

    @PostMapping("/login")
    public String login(@RequestBody LoginRequest request) {

        // demo purpose (later DB check pannanum)
        if ("admin@gmail.com".equals(request.getEmail()) &&
                "1234".equals(request.getPassword())) {

            return jwtUtil.generateToken(request.getEmail());
        }

        return "Invalid Credentials";
    }

    @Data
    static class LoginRequest {
        private String email;
        private String password;
    }
}