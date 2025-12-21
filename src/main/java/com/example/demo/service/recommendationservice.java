package com.example.demo.service;
public class recommendationservice{
    recommendation generateRecommendation(Long intentId);
    ->fetch intent
    ->fetch active cards for user
    ->fetch active rules for card + category
    ->calculated reward
    
    recommendation getRecommendationById(Long id);
    recommendation getRecommendationByUSer(Long userId);
    recommendation getAllRecommendations();
}