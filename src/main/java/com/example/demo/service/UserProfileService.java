package com.example.demo.service;

import com.example.demo.entity.UserProfile;

public interface UserProfileService {

    UserProfile createUser(UserProfile user);

    UserProfile login(String email, String password);
}
