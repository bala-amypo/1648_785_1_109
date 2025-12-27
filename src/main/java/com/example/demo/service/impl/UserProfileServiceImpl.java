package com.example.demo.service.impl;

import com.example.demo.entity.UserProfile;
import com.example.demo.repository.UserProfileRepository;
import com.example.demo.service.UserProfileService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UserProfileServiceImpl implements UserProfileService {
    private final UserProfileRepository repo;
    private final PasswordEncoder encoder;

    public UserProfileServiceImpl(UserProfileRepository repo, PasswordEncoder encoder) {
        this.repo = repo;
        this.encoder = encoder;
    }

    @Override
    public UserProfile createUser(UserProfile user) {
        if (repo.existsByEmail(user.getEmail())) {
            throw new BadRequestException("Email exists");
        }
        user.setPassword(encoder.encode(user.getPassword()));
        return repo.save(user);
    }

    @Override
    public UserProfile getUserById(Long id) {
        return repo.findById(id).orElseThrow(() -> new ResourceNotFoundException("User not found"));
    }

    @Override
    public List<UserProfile> getAllUsers() { return repo.findAll(); }
}