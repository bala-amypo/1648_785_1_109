package com.example.demo.service;

import com.example.demo.entity.RewardRule;

import java.util.List;

public interface RewardRuleService {
    RewardRule addRewardRule(RewardRule rule);
    RewardRule getRewardRuleById(Long id);
    List<RewardRule> getAllRewardRules();
    void deleteRewardRule(Long id);
}
