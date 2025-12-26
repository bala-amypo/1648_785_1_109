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

    @Override
    public void registerUser(RegisterRequest request) {
        UserProfile user = new UserProfile();
        user.setUserId(request.getUserId());
        user.setFullName(request.getFullName());
        user.setEmail(request.getEmail());
        user.setRole(request.getRole());
        // This fixes the setPassword error
        user.setPassword(passwordEncoder.encode(request.getPassword())); 
        userRepository.save(user);
    }

    @Override
    public UserProfile createUser(UserProfile profile) {
        profile.setPassword(passwordEncoder.encode(profile.getPassword()));
        return userRepository.save(profile);
    }

    @Override
    public UserProfile getUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public List<UserProfile> getAllUsers() {
        return userRepository.findAll();
    }
}