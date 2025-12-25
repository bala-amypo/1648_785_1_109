package com.example.demo.repository;

import com.example.demo.entity.*;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.*;

public interface RewardRuleRepository extends JpaRepository<RewardRule, Long> {
    List<RewardRule> findByActiveTrue();
    List<RewardRule> findActiveRulesForCardCategory(Long cardId, String category);
}
