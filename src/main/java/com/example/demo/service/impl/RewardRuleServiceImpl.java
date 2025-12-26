package com.example.demo.service.impl;

import com.example.demo.entity.RewardRule;
import com.example.demo.repository.RewardRuleRepository;
import com.example.demo.service.RewardRuleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RewardRuleServiceImpl implements RewardRuleService {

    private final RewardRuleRepository repository;

    @Override
    public RewardRule addRewardRule(RewardRule rule) {
        return repository.save(rule);
    }

    @Override
    public RewardRule getRewardRuleById(Long id) {
        return repository.findById(id).orElse(null);
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
