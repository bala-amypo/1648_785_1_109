package com.example.demo.service.impl;

import com.example.demo.service.RecommendationEngineService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List; 

@Service
public class RecommendationEngineServiceImpl implements RecommendationEngineService {

    @Override
    public List<String> generateRecommendation(Long userId) {
        List<String> recommendations = new ArrayList<>();
        recommendations.add("Best Credit Card");
        return recommendations;
    }
}
