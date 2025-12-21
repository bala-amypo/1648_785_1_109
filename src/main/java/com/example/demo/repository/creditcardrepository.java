package com.example.demo.repository;

import com.example.demo.entity.UserProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;
public interface creditcard extends JpaRepository<CreditCardRecord, Long> {
    List<creditcard> findByUserId(Long userId);
}

