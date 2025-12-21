package com.example.demo.service.impl;

import com.example.demo.entity.userprofile;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.UserProfileRepository;
import com.example.demo.service.UserProfileService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserProfileServiceImpl implements UserProfileService {

    private final UserProfileRepository users;
    private final PasswordEncoder passwordEncoder;

    // Constructor Injection (BEST PRACTICE)
    public UserProfileServiceImpl(UserProfileRepository users,
                                  PasswordEncoder passwordEncoder) {
        this.users = users;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public userprofile createUser(userprofile profile) {
        profile.setPassword(passwordEncoder.encode(profile.getPassword()));
        profile.setActive(true);
        return users.save(profile);
    }

    @Override
    public userprofile getUserById(Long id) {
        return users.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));
    }

    @Override
    public userprofile findByUserId(String userId) {
        return users.findByUserId(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));
    }

    @Override
    public List<userprofile> getAllUsers() {
        return users.findAll();
    }

    @Override
    public userprofile updateUserStatus(Long id, boolean active) {
        userprofile user = getUserById(id);
        user.setActive(active);
        return users.save(user);
    }
}
