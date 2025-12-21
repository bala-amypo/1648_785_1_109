package com.example.demo.controller;

import com.example.demo.entity.rewardrule;
import com.example.demo.service.rewardruleservice;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reward-rules")
public class rewardrulecontroller {

    private final rewardruleservice service;

    // Constructor Injection
    public rewardrulecontroller(rewardruleservice service) {
        this.service = service;
    }

    // Create reward rule
    @PostMapping("/POST")
    public rewardrule createRule(@RequestBody rewardrule rule) {
        return service.createRule(rule);
    }

    // Update reward rule
    @PutMapping("/PUT/{id}")
    public rewardrule updateRule(
            @PathVariable Long id,
            @RequestBody rewardrule updated) {
        return service.updateRule(id, updated);
    }

    // Get reward rules by card ID
    @GetMapping("GET/card/{cardId}")
    public List<rewardrule> getRulesByCard(@PathVariable Long cardId) {
        return service.getRulesByCard(cardId);
    }

    // Get all active reward rules
    @GetMapping("GET/active")
    public List<rewardrule> getActiveRules() {
        return service.getActiveRules();
    }

    // Get all reward rules
    @GetMapping
    public List<rewardrule> getAllRules() {
        return service.getAllRules();
    }
}
