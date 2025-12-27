package com.example.demo.service.impl;

import com.example.demo.entity.UserProfile;
import com.example.demo.dto.RegisterRequest;
import com.example.demo.repository.UserProfileRepository;
import com.example.demo.service.UserProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UserProfileServiceImpl implements UserProfileService {

    @Autowired
    private UserProfileRepository userRepository;

    @Override
    public List<UserProfile> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public UserProfile getUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public UserProfile createUser(UserProfile profile) {
        return userRepository.save(profile);
    }

    @Override
    public void updateUserStatus(Long id, boolean active) {
        userRepository.findById(id).ifPresent(user -> {
            user.setActive(active);
            userRepository.save(user);
        });
    }

    @Override
    public void registerUser(RegisterRequest request) {
        // Implementation logic for registration
    }
}