package com.example.demo.service.impl;

import com.example.demo.entity.userprofile;
import com.example.demo.repository.userprofilerepository;
import com.example.demo.service.userprofileservice;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Userprofileimpl implements userprofileservice {

    private final userprofilerepository users;

    // Constructor Injection
    public Userprofileimpl(userprofilerepository users) {
        this.users = users;
    }

    @Override
    public userprofile createUser(userprofile profile) {
        profile.setActive(true);
        return users.save(profile);
    }

    @Override
    public userprofile getUserById(Long id) {
        return users.findById(id).orElse(null);
    }

    @Override
    public userprofile findByUserId(String userId) {
        return users.findByUserId(userId).orElse(null);
    }

    @Override
    public List<userprofile> getAllUsers() {
        return users.findAll();
    }

    @Override
    public userprofile updateUserStatus(Long id, boolean active) {
        userprofile user = getUserById(id);
        if (user != null) {
            user.setActive(active);
            return users.save(user);
        }
        return null;
    }
}
