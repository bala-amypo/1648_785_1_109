package com.example.demo.service.impl;

import com.example.demo.entity.UserProfile;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.UserProfileRepository;
import com.example.demo.service.UserProfileService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserProfileServiceImpl implements UserProfileService {
    public UserProfileServiceImpl(UserProfileRepository repository,
                                  PasswordEncoder passwordEncoder) {
        this.repository = repository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public UserProfile createUser(UserProfile profile) {
        profile.setPassword(passwordEncoder.encode(profile.getPassword()));
        profile.setActive(true);
        return repository.save(profile);
    }

    @Override
    public UserProfile getUserById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));
    }

    @Override
    public UserProfile findByUserId(String userId) {
        return repository.findByUserId(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));
    }

    @Override
    public List<UserProfile> getAllUsers() {
        return repository.findAll();
    }

    @Override
    public UserProfile updateUserStatus(Long id, boolean active) {
        UserProfile user = getUserById(id);
        user.setActive(active);
        return repository.save(user);
    }
}


package com.example.demo.service.imples;


@Service
public class userprofileimples implements userprofileservice{
@Autowired userprofilerepository user;
    @Override
    public UserProfile createUser(UserProfile profile) {
        profile.setPassword(passwordEncoder.encode(profile.getPassword()));
        profile.setActive(true);
        return repository.save(profile);
    }
     @Override
    public UserProfile getUserById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));
    }

    @Override
    public UserProfile findByUserId(String userId) {
        return repository.findByUserId(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));
    }
}