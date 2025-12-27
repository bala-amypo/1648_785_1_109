package com.example.demo.service;

import com.example.demo.entity.UserProfile;
import com.example.demo.dto.RegisterRequest; // Ensure this DTO exists
import java.util.List;

public interface UserProfileService {
    UserProfile createUser(UserProfile user);
    UserProfile getUserById(Long id);
    List<UserProfile> getAllUsers();
}