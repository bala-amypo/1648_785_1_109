package com.example.demo.service.impl;
import com.example.demo.entity.userprofile;
import com.example.demo.repository.UserProfileRepository;
import com.example.demo.service.userprofileservice;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class userprofileserviceimples implements userprofileservice {

    private final userprofilerepository users;
    public userprofileserviceimples(userprofilerepository users) {
        this.users = users;
    }

    @Override
    public userprofile createUser(userprofile profile) {
        profile.setPassword(profile.getPassword());
        profile.setActive(true);
        return users.save(profile);
    }

    @Override
    public userprofile getUserById(Long id) {
        return users.findById(id)
                .orElseThrow(null);
    }

    @Override
    public userprofile findByUserId(String userId) {
        return users.findByUserId(userId)
                .orElseThrow(null);
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
