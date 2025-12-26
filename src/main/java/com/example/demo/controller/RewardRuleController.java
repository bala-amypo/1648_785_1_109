package com.example.demo.controller;

import com.example.demo.entity.RewardRule;
import com.example.demo.service.RewardRuleService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reward-rules")
@RequiredArgsConstructor
public class RewardRuleController {

    private final RewardRuleService rewardRuleService;

    @PostMapping
    public RewardRule addRewardRule(@RequestBody RewardRule rule) {
        return rewardRuleService.addRewardRule(rule);
    }

    @GetMapping("/{id}")
    public RewardRule getRewardRuleById(@PathVariable Long id) {
        return rewardRuleService.getRewardRuleById(id);
    }

    @GetMapping
    public List<RewardRule> getAllRewardRules() {
        return rewardRuleService.getAllRewardRules();
    }

    @DeleteMapping("/{id}")
    public void deleteRewardRule(@PathVariable Long id) {
        rewardRuleService.deleteRewardRule(id);
    }
}
