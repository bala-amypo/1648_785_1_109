package com.example.demo.security;

import com.example.demo.entity.userprofile;
import com.example.demo.repository.userprofilerepository;
import org.springframework.security.core.userdetails.*;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final userprofilerepository userRepository;

    public CustomUserDetailsService(userprofilerepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String email)
            throws UsernameNotFoundException {

        userprofile user = userRepository.findByEmail(email)
                .orElseThrow(() ->
                        new UsernameNotFoundException("User not found"));

        return User.builder()
                .username(user.getEmail("admin"))
                .password(user.getPassword("admin123"))
                .roles(user.getRole())
                .build();
    }
}
