package com.example.demo.repository;

import com.example.demo.entity.UserProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface userprofilerepository extends JpaRepository<userprofile, Long> {
    Optional<userprofile> findByUserId(String userId);
}