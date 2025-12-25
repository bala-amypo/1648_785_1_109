// package com.example.demo.service;

// import org.springframework.stereotype.Service;
// import com.example.demo.entity.User;
// import com.example.demo.repository.UserRepository;
// import java.util.List;
// import java.util.Optional;

// @Service
// public class UserProfileService {

//     private final UserRepository userRepository;

//     // Constructor injection
//     public UserProfileService(UserRepository userRepository) {
//         this.userRepository = userRepository;
//     }

//     // Get all users
//     public List<User> getAllUsers() {
//         return userRepository.findAll();
//     }

//     // Get user by ID
//     public Optional<User> getUserById(Long id) {
//         return userRepository.findById(id);
//     }

//     // Save a user
//     public User saveUser(User user) {
//         return userRepository.save(user);
//     }

//     // Delete user by ID
//     public void deleteUser(Long id) {
//         userRepository.deleteById(id);
//     }
// }
