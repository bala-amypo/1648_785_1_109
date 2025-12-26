package com.example.demo.service.impl;

import com.example.demo.entity.UserProfile;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.UserProfileRepository;
import com.example.demo.service.UserProfileService;
import org.springframework.stereotype.Service;

@Service
public class UserProfileServiceImpl implements UserProfileService {

    private final UserProfileRepository repository;

    public UserProfileServiceImpl(UserProfileRepository repository) {
        this.repository = repository;
    }

    @Override
    public UserProfile createUser(UserProfile userProfile) {
        userProfile.setActive(true);
        return repository.save(userProfile);
    }

    @Override
    public UserProfile getUserByEmail(String email) {
        return repository.findByEmail(email)
                .orElseThrow(() ->
                        new ResourceNotFoundException("User not found"));
    }

    @Override
    public UserProfile activateUser(Long id) {
        UserProfile user = repository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("User not found"));
        user.setActive(true);
        return repository.save(user);
    }
}
