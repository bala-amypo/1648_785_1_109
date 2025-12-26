package com.example.demo.service.impl;

import com.example.demo.entity.UserProfile;
import com.example.demo.exception.BadRequestException;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.UserProfileRepository;
import com.example.demo.service.UserProfileService;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;

public class UserProfileServiceImpl implements UserProfileService {

    private final UserProfileRepository repository;
    private final PasswordEncoder passwordEncoder;

    public UserProfileServiceImpl(UserProfileRepository repository,
                                  PasswordEncoder passwordEncoder) {
        this.repository = repository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public UserProfile createUser(UserProfile userProfile) {

        if (repository.existsByEmail(userProfile.getEmail())) {
            throw new BadRequestException("Email already exists");
        }

        if (repository.existsByUserId(userProfile.getUserId())) {
            throw new BadRequestException("UserId already exists");
        }

        userProfile.setPassword(
                passwordEncoder.encode(userProfile.getPassword()));
        userProfile.setActive(true);

        return repository.save(userProfile);
    }

    @Override
    public UserProfile getUserById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));
    }

    @Override
    public UserProfile findByEmail(String email) {
        return repository.findByEmail(email)
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));
    }

    @Override
    public List<UserProfile> getAllUsers() {
        return repository.findAll();
    }

    @Override
    public UserProfile updateUserStatus(Long id, boolean active) {
        UserProfile user = getUserById(id);
        user.setActive(active);
        return repository.save(user);
    }
}
