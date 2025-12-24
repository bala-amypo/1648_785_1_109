package com.example.demo.security;

import com.example.demo.dto.JwtResponse;
import com.example.demo.dto.LoginRequest;
import com.example.demo.entity.userprofile;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.userprofilerepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class JwtAuthenticationService {

    private final userprofilerepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;

    public JwtAuthenticationService(
            userprofilerepository userRepository,
            PasswordEncoder passwordEncoder,
            JwtUtil jwtUtil) {

        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtUtil = jwtUtil;
    }

    public JwtResponse login(LoginRequest request) {

        userprofile user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(() ->
                        new ResourceNotFoundException("Invalid credentials"));

        if (!passwordEncoder.matches(
                request.getPassword(), user.getPassword())) {
            throw new ResourceNotFoundException("Invalid credentials");
        }

        String token = jwtUtil.generateToken(user.getEmail());

        return new JwtResponse(
                token,
                user.getId(),
                user.getEmail(),
                user.getRole()
        );
    }
}
