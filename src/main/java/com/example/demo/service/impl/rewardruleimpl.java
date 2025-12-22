package com.example.demo.service.impl;

import com.example.demo.entity.rewardrule;
import com.example.demo.repository.rewardrulerepository;
import com.example.demo.service.rewardruleservice;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class rewardruleimpl implements rewardruleservice {

    private final rewardrulerepository repository;

    // Constructor Injection
    public rewardruleimpl(rewardrulerepository repository) {
        this.repository = repository;
    }

  @Override
public rewardrule createRule(rewardrule rule) {

    if (rule.getMultiplier() <= 0) {
        throw new badrequestexception("Multiplier must be greater than 0");
    }
    rule.setActive(true);
    return repository.save(rule);
}

    @Override
    public rewardrule updateRule(Long id, rewardrule updated) {
        rewardrule existing = repository.findById(id).orElse(null);
        if (existing != null) {
            existing.setCategory(updated.getCategory());
            existing.setRewardType(updated.getRewardType());
            existing.setMultiplier(updated.getMultiplier());
            existing.setActive(updated.getActive());
            return repository.save(existing);
        }
        return null;
    }

    @Override
    public List<rewardrule> getRulesByCard(Long cardId) {
        return repository.findByCardId(cardId);
    }

    @Override
    public List<rewardrule> getActiveRules() {
        return repository.findByActiveTrue();
    }

    @Override
    public List<rewardrule> getAllRules() {
        return repository.findAll();
    }
}
