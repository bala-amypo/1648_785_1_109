package com.example.demo.repository;

import com.example.demo.entity.*;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.*;
public interface RecommendationRecordRepository extends JpaRepository<RecommendationRecord, Long> {
    List<RecommendationRecord> findByUserId(Long userId);
}

