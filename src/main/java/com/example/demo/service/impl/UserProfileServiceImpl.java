package com.example.demo.service.impl;

import com.example.demo.entity.UserProfile;
import com.example.demo.service.UserProfileService;
import org.springframework.stereotype.Service;

@Service
public class UserProfileServiceImpl implements UserProfileService {

    @Override
    public UserProfile createUser(UserProfile user) {
        return user; // simple stub for now
    }

    @Override
    public UserProfile login(String email, String password) {
        return null; // stub
    }
}
