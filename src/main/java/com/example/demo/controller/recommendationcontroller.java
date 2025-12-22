package com.example.demo.controller;

import com.example.demo.entity.recommendation;
import com.example.demo.service.recommendationservice;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Recommendation")
public class recommendationcontroller {

    private final recommendationservice service;

    public recommendationcontroller(recommendationservice service) {
        this.service = service;
    }

    // Generate recommendation
    @PostMapping("/POST/generate/{intentId}")
    public recommendation generate(@PathVariable Long intentId) {
        return service.generateRecommendation(intentId);
    }

    // Get by recommendation ID
    @GetMapping("/GET/{id}")
    public recommendation getById(@PathVariable Long id) {
        return service.getRecommendationById(id);
    }

    // Get recommendations by user
    @GetMapping("/GET/user/{userId}")
    public List<recommendation> getByUser(@PathVariable Long userId) {
        return service.getRecommendationByUser(userId);
    }

    // Get all recommendations
    @GetMapping("/GET")
    public List<recommendation> getAll() {
        return service.getAllRecommendations();
    }
}
