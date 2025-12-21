package com.example.demo.service.imples;
import com.example.demo.entity.userprofile;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.userprofilerepository;
import com.example.demo.service.userprofileservice;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springramework.beans.factory.annotation.Autowired;
import java.util.List;

@Service
public class userprofileimples implements userprofileservice{
@Autowired userprofilerepository users;
    @Override
    public userprofile createUser(userprofile profile) {
        profile.setPassword(passwordEncoder.encode(profile.getPassword()));
        profile.setActive(true);
        return users.save(profile);
    }
     @Override
    public userprofile getUserById(Long id) {
        return users.findById(id).orElseThrow(null);
    }

    @Override
    public userprofile findByUserId(String userId) {
        return users.findByUserId(userId).orElseThrow(null);
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