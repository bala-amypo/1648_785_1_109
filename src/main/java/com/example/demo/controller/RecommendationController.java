package com.example.demo.controller;

import com.example.demo.entity.CreditCardRecord;
import com.example.demo.service.RecommendationEngineService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/recommendations")
@RequiredArgsConstructor
public class RecommendationController {

    private final RecommendationEngineService recommendationService;

    @GetMapping("/generate/{userId}")
    public CreditCardRecord generateRecommendation(@PathVariable Long userId) {
        return recommendationService.generateRecommendation(userId);
    }

    @GetMapping("/user/{userId}")
    public List<CreditCardRecord> getRecommendationsByUser(@PathVariable Long userId) {
        return recommendationService.getRecommendationsByUser(userId);
    }

    @GetMapping
    public List<CreditCardRecord> getAllRecommendations() {
        return recommendationService.getAllRecommendations();
    }
}
