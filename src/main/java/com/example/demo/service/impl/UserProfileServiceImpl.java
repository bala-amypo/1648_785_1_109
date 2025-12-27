package com.example.demo.service.impl;

import com.example.demo.entity.UserProfile;
import com.example.demo.exception.BadRequestException;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.UserProfileRepository;
import com.example.demo.service.UserProfileService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserProfileServiceImpl implements UserProfileService {

    private final UserProfileRepository repo;
    private final PasswordEncoder encoder;

    public UserProfileServiceImpl(UserProfileRepository userProfileRepository,
                                  PasswordEncoder passwordEncoder) {
        this.repo = userProfileRepository;
        this.encoder = passwordEncoder;
    }

    @Override
    public UserProfile createUser(UserProfile profile) {
        if (profile.getEmail() == null || profile.getPassword() == null) {
            throw new BadRequestException("Email and password are required");
        }
        if (repo.existsByEmail(profile.getEmail())) {
            throw new BadRequestException("Duplicate email");
        }
        if (profile.getUserId() != null && repo.existsByUserId(profile.getUserId())) {
            throw new BadRequestException("Duplicate userId");
        }

        // Encode password
        profile.setPassword(encoder.encode(profile.getPassword()));
        profile.prePersist(); // set createdAt and default role if needed
        return repo.save(profile);
    }

    @Override
    public UserProfile getUserById(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not found: " + id));
    }

    @Override
    public UserProfile findByUserId(String userId) {
        return repo.findAll().stream()
                .filter(u -> userId.equals(u.getUserId()))
                .findFirst()
                .orElseThrow(() -> new ResourceNotFoundException("User not found by userId: " + userId));
    }

    @Override
    public List<UserProfile> getAllUsers() {
        return repo.findAll();
    }

    @Override
    public UserProfile updateUserStatus(Long id, boolean active) {
        UserProfile user = getUserById(id);
        user.setActive(active);
        return repo.save(user);
    }
}
