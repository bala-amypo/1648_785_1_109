package com.example.demo.service.impl;

import com.example.demo.entity.RewardRule;
import com.example.demo.exception.BadRequestException;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.RewardRuleRepository;
import com.example.demo.service.RewardRuleService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service   // <-- critical annotation
@Transactional
public class RewardRuleServiceImpl implements RewardRuleService {

    private final RewardRuleRepository repo;

    public RewardRuleServiceImpl(RewardRuleRepository rewardRuleRepository) {
        this.repo = rewardRuleRepository;
    }

    @Override
    public RewardRule createRule(RewardRule rule) {
        if (rule.getMultiplier() == null || rule.getMultiplier() <= 0.0) {
            throw new BadRequestException("Price multiplier must be > 0");
        }
        return repo.save(rule);
    }

    @Override
    public RewardRule updateRule(Long id, RewardRule updated) {
        RewardRule r = repo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Rule not found: " + id));
        r.setCategory(updated.getCategory());
        r.setRewardType(updated.getRewardType());
        r.setMultiplier(updated.getMultiplier());
        r.setActive(updated.getActive());
        return repo.save(r);
    }

    @Override
    public List<RewardRule> getRulesByCard(Long cardId) {
        return repo.findAll().stream()
                .filter(r -> cardId.equals(r.getCardId()))
                .toList();
    }

    @Override
    public List<RewardRule> getActiveRules() {
        return repo.findByActiveTrue();
    }

    @Override
    public List<RewardRule> getAllRules() {
        return repo.findAll();
    }
}
