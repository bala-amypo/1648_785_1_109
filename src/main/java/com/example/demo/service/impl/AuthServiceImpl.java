package com.example.demo.service.impl;

import com.example.demo.dto.RegisterRequest;
import com.example.demo.dto.LoginRequest;
import com.example.demo.service.AuthService;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {

    @Override
    public Object register(RegisterRequest request) {
        // implement registration logic
        return "User registered successfully!";
    }

    @Override
    public Object login(LoginRequest request) {
        // implement login logic
        return "User logged in successfully!";
    }
}
