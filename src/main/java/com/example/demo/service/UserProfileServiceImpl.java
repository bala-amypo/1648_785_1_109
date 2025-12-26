package com.example.demo.service;

import com.example.demo.entity.UserProfile;

public interface UserProfileService {

    UserProfile createUser(UserProfile userProfile);

    UserProfile getUserByEmail(String email);

    UserProfile activateUser(Long id);
}
