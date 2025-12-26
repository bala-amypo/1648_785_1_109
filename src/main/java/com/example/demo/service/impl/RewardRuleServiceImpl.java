package com.example.demo.service.impl;

import com.example.demo.entity.RewardRule;
import com.example.demo.repository.RewardRuleRepository;
import com.example.demo.service.RewardRuleService;
import com.example.demo.exception.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class RewardRuleServiceImpl implements RewardRuleService {

    private final RewardRuleRepository repository;

    public RewardRuleServiceImpl(RewardRuleRepository repository) {
        this.repository = repository;
    }

    // Test Mappings
    @Override
    public RewardRule createRule(RewardRule rule) {
        return repository.save(rule);
    }

    @Override
    public List<RewardRule> getActiveRules() {
        return repository.findByActiveTrue();
    }

    @Override
    public List<RewardRule> getAllRules() {
        return repository.findAll();
    }

    // Controller Mappings
    @Override
    public RewardRule addRewardRule(RewardRule rule) {
        return repository.save(rule);
    }

    @Override
    public RewardRule getRewardRuleById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Rule not found"));
    }

    @Override
    public List<RewardRule> getAllRewardRules() {
        return repository.findAll();
    }

    @Override
    public void deleteRewardRule(Long id) {
        repository.deleteById(id);
    }
}