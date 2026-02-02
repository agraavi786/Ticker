package com.ticker.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ticker.auth.JwtUtil;
import com.ticker.dto.AuthDto;
import com.ticker.dto.AuthResponseDto;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final JwtUtil jwtUtil;

    public AuthController(JwtUtil jwtUtil) {
        this.jwtUtil = jwtUtil;
    }

    @PostMapping("/login")
    public AuthResponseDto login(@RequestBody AuthDto request) {
        if (!"user1".equals(request.getUsername())
                || !"password".equals(request.getPassword())) {
            throw new RuntimeException("Invalid credentials");
        }
        return new AuthResponseDto(jwtUtil.generateToken(request.getUsername()));
    }
}
