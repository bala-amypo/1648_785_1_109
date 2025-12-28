package com.example.demo.service.impl;

import com.example.demo.service.AuthService;
import com.example.demo.dto.RegisterRequest;
import com.example.demo.dto.JwtResponse;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {
    @Override
    public JwtResponse register(RegisterRequest request) {
        // implement registration logic
        return new JwtResponse();
    }

    @Override
    public JwtResponse login(LoginRequest request) {
        // implement login logic
        return new JwtResponse();
    }
}
