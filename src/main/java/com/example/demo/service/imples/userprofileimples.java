// package com.example.demo.service;

// import com.example.demo.entity.UserProfile;
// import com.example.demo.exception.ResourceNotFoundException;
// import com.example.demo.repository.UserProfileRepository;
// import org.springframework.security.crypto.password.PasswordEncoder;
// import org.springframework.stereotype.Service;
// import java.util.List;

// @Service
// public class userprofileimles {

//     private final UserProfileRepository repository;
//     private final PasswordEncoder passwordEncoder;

//     public UserProfileService(UserProfileRepository repository,PasswordEncoder passwordEncoder) {
//         this.repository = repository;
//         this.passwordEncoder = passwordEncoder;
//     }

//     public userprofile createUser(userprofile profile) {
//         profile.setPassword(passwordEncoder.encode(profile.getPassword()));
//         profile.setActive(true);
//         return repository.save(profile);
//     }

//     public userprofile getUserById(Long id) {
//         return repository.findById(id)
//                 .orElseThrow(() -> new ResourceNotFoundException("User not found"));
//     }

//     public userprofile findByUserId(String userId) {
//         return repository.findByUserId(userId)
//                 .orElseThrow(() -> new ResourceNotFoundException("User not found"));
//     }

//     public List<userprofile> getAllUsers() {
//         return repository.findAll();
//     }

//     public userprofile updateUserStatus(Long id, boolean active) {
//         userprofile user = getUserById(id);
//         user.setActive(active);
//         return repository.save(user);
//     }
// }

package com.example.demo.service.imples;


@Service
public class userprofileimples implements userprofileservice{
@Autowired userprofilerepository user;
@Override
public userprofile 
}