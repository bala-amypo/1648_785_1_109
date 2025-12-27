package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.*;

public interface UserProfileRepository extends JpaRepository<UserProfile, Long> {
    boolean existsByEmail(String email);
    boolean existsByUserId(String userId);
    Optional<UserProfile> findByEmail(String email);
}
