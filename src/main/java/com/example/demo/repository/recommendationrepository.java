package com.example.demo.repository;

import com.example.demo.entity.recommendation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface recommendationrepository
        extends JpaRepository<recommendation, Long> {
    List<recommendation> findByUserId(Long userId);
}
