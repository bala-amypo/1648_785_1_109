package com.example.demo.service.impl;

import com.example.demo.entity.UserProfile;
import com.example.demo.repository.UserProfileRepository;
import com.example.demo.service.UserProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UserProfileServiceImpl implements UserProfileService {

    @Autowired
    private UserProfileRepository userRepository;

    // Added this missing method to satisfy the interface
    @Override
    public List<UserProfile> getAllUsers() {
        return userRepository.findAll();
    }

    // ... keep your other existing methods like updateStatus here
}