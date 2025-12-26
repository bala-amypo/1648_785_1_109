package com.example.demo.service.impl;

import com.example.demo.dto.RegisterRequest;
import com.example.demo.entity.UserProfile;
import com.example.demo.repository.UserProfileRepository;
import com.example.demo.service.UserProfileService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UserProfileServiceImpl implements UserProfileService {

    private final UserProfileRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserProfileServiceImpl(UserProfileRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    // Existing methods (registerUser, createUser, etc.) should remain here...

    @Override
    public void updateUserStatus(Long id, boolean active) {
        UserProfile user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found with id: " + id));
        user.setActive(active);
        userRepository.save(user);
    }
    
    // Ensure getUserById, getAllUsers, etc., are also implemented
}