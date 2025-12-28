package com.example.demo.service;

import com.example.demo.dto.RegisterRequest;
import com.example.demo.dto.LoginRequest;

public interface AuthService {
    Object register(RegisterRequest request);
    Object login(LoginRequest request);
}
