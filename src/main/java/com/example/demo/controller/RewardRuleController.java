package com.example.demo.controller;

import com.example.demo.entity.RewardRule;
import com.example.demo.service.RewardRuleService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/reward-rules")
public class RewardRuleController {

  private final RewardRuleService service;

  public RewardRuleController(RewardRuleService service) {
    this.service = service;
  }

  @PostMapping
  public ResponseEntity<RewardRule> create(@RequestBody RewardRule rule) {
    return ResponseEntity.ok(service.createRule(rule));
  }

  @PutMapping("/{id}")
  public ResponseEntity<RewardRule> update(@PathVariable Long id, @RequestBody RewardRule updated) {
    return ResponseEntity.ok(service.updateRule(id, updated));
  }

  @GetMapping("/card/{cardId}")
  public ResponseEntity<List<RewardRule>> byCard(@PathVariable Long cardId) {
    return ResponseEntity.ok(service.getRulesByCard(cardId));
  }

  @GetMapping("/active")
  public ResponseEntity<List<RewardRule>> active() {
    return ResponseEntity.ok(service.getActiveRules());
  }

  @GetMapping
  public ResponseEntity<List<RewardRule>> all() {
    return ResponseEntity.ok(service.getAllRules());
  }
}
