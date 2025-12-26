package com.example.demo.service;

import com.example.demo.entity.RewardRule;
import java.util.List;

public interface RewardRuleService {
    // Methods for the Test
    RewardRule createRule(RewardRule rule);
    List<RewardRule> getActiveRules();
    List<RewardRule> getAllRules();

    // Methods for the Controller
    RewardRule addRewardRule(RewardRule rule);
    RewardRule getRewardRuleById(Long id);
    List<RewardRule> getAllRewardRules();
    void deleteRewardRule(Long id);
}