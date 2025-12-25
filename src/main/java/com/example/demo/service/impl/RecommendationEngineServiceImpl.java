package com.example.demo.service.impl;

import com.example.demo.entity.*;
import com.example.demo.exception.BadRequestException;
import com.example.demo.repository.*;
import com.example.demo.service.RecommendationEngineService;

public class RecommendationEngineServiceImpl implements RecommendationEngineService {

    private final PurchaseIntentRecordRepository intentRepo;
    private final UserProfileRepository userRepo;
    private final CreditCardRecordRepository cardRepo;
    private final RewardRuleRepository ruleRepo;
    private final RecommendationRecordRepository recRepo;

    public RecommendationEngineServiceImpl(
            PurchaseIntentRecordRepository i,
            UserProfileRepository u,
            CreditCardRecordRepository c,
            RewardRuleRepository r,
            RecommendationRecordRepository rec) {
        this.intentRepo = i;
        this.userRepo = u;
        this.cardRepo = c;
        this.ruleRepo = r;
        this.recRepo = rec;
    }

    public RecommendationRecord generateRecommendation(Long intentId) {
        PurchaseIntentRecord intent = intentRepo.findById(intentId).orElseThrow();
        UserProfile user = userRepo.findById(intent.getUserId()).orElseThrow();

        var cards = cardRepo.findActiveCardsByUser(user.getId());
        if (cards.isEmpty()) throw new BadRequestException("No cards");

        CreditCardRecord card = cards.get(0);
        RewardRule rule = ruleRepo
                .findActiveRulesForCardCategory(card.getId(), intent.getCategory())
                .get(0);

        RecommendationRecord rec = new RecommendationRecord();
        rec.setUserId(user.getId());
        rec.setPurchaseIntentId(intent.getId());
        rec.setRecommendedCardId(card.getId());
        rec.setExpectedRewardValue(intent.getAmount() * rule.getMultiplier());

        return recRepo.save(rec);
    }

    public List<RecommendationRecord> getRecommendationsByUser(Long userId) {
        return recRepo.findByUserId(userId);
    }

    public List<RecommendationRecord> getAllRecommendations() {
        return recRepo.findAll();
    }
}
