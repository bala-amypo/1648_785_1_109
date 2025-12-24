package com.example.demo.security;

import com.example.demo.dto.LoginRequest;
import org.springframework.stereotype.Service;

@Service
public class JwtAuthenticationService {

    public String authenticate(LoginRequest request) {

        String username = request.getUsername();
        String password = request.getPassword();


        if ("Naveen1810".equals(username) && "Naveen@cr7".equals(password)) {
            return "dummy-jwt-token";
        }

        throw new RuntimeException("Invalid credentials");
    }
}
