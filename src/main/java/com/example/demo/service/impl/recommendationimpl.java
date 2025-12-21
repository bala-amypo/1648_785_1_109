package com.example.demo.service.impl;

import com.example.demo.entity.recommendation;
import com.example.demo.entity.purchaseintent;
import com.example.demo.repository.recommendationrepository;
import com.example.demo.repository.purchaseintentrepository;
import com.example.demo.service.recommendationservice;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class recommendationimpl implements recommendationservice {

    private final recommendationrepository recommendationRepo;
    private final purchaseintentrepository intentRepo;

    public recommendationimpl(
            recommendationrepository recommendationRepo,
            purchaseintentrepository intentRepo) {
        this.recommendationRepo = recommendationRepo;
        this.intentRepo = intentRepo;
    }

    @Override
    public recommendation generateRecommendation(Long intentId) {

        purchaseintent intent = intentRepo.findById(intentId).orElse(null);
        if (intent == null) {
            return null;
        }

        recommendation rec = new recommendation();
        rec.setUserId(intent.getUserId());
        rec.setPurchaseIntentId(intent.getId());

        // temporary static values (can be replaced later)
        rec.setRecommendedCardId(1L);
        rec.setExpectedRewardValue(0.0);
        rec.setCalculationDetailsJson("Reward calculation pending");

        return recommendationRepo.save(rec);
    }

    @Override
    public recommendation getRecommendationById(Long id) {
        return recommendationRepo.findById(id).orElse(null);
    }

    @Override
    public List<recommendation> getRecommendationByUser(Long userId) {
        return recommendationRepo.findByUserId(userId);
    }

    @Override
    public List<recommendation> getAllRecommendations() {
        return recommendationRepo.findAll();
    }
}
