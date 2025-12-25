package com.example.demo.repository;

import com.example.demo.entity.*;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.*;

public interface UserProfileRepository extends JpaRepository<UserProfile, Long> {

    boolean existsById(Long id);

    Optional<UserProfile> findByEmail(String email);
}
