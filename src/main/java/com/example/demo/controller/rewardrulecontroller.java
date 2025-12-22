package com.example.demo.controller;

import com.example.demo.entity.rewardrule;
import com.example.demo.service.rewardruleservice;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Rewrdrule")
public class rewardrulecontroller {

    private final rewardruleservice service;

    public rewardrulecontroller(rewardruleservice service) {
        this.service = service;
    }

    @PostMapping("/POST")
    public rewardrule createRule(@RequestBody rewardrule rule) {
        return service.createRule(rule);
    }

    @PutMapping("/PUT/{id}")
    public rewardrule updateRule(@PathVariable Long id,@RequestBody rewardrule updated) {
        return service.updateRule(id, updated);
    }

    @GetMapping("GET/card/{cardId}")
    public List<rewardrule> getRulesByCard(@PathVariable Long cardId) {
        return service.getRulesByCard(cardId);
    }

    @GetMapping("GET/active")
    public List<rewardrule> getActiveRules() {
        return service.getActiveRules();
    }
    
    @GetMapping("/GET")
    public List<rewardrule> getAllRules() {
        return service.getAllRules();
    }
}
