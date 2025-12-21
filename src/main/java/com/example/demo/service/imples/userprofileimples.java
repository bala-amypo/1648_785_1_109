package com.example.demo.service.imples;
import com.example.demo.entity.userprofile;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.UserProfileRepository;
import com.example.demo.service.UserProfileService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class userprofileimples implements userprofileservice{
@Autowired userprofilerepository user;
    @Override
    public userprofile createUser(userprofile profile) {
        profile.setPassword(passwordEncoder.encode(profile.getPassword()));
        profile.setActive(true);
        return user.save(profile);
    }
     @Override
    public userprofile getUserById(Long id) {
        return user.findById(id).orElseThrow(() -> new ResourceNotFoundException("User not found"));
    }

    @Override
    public userprofile findByUserId(String userId) {
        return user.findByUserId(userId).orElseThrow(() -> new ResourceNotFoundException("User not found"));
    }
    @Override
    public List<userprofile> getAllUsers() {
        return user.findAll();
    }
    @Override
    public userprofile updateUserStatus(Long id, boolean active) {
        userprofile user = getUserById(id);
        user.setActive(active);
        return user.save(user);
    }
}