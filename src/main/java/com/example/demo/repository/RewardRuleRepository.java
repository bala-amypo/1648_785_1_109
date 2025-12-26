package com.example.demo.repository;

import com.example.demo.entity.RewardRule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RewardRuleRepository extends JpaRepository<RewardRule, Long> {
    // Additional query methods if needed
}
