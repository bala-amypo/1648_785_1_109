package com.example.demo.service.impl;

import com.example.demo.entity.*;
import com.example.demo.exception.BadRequestException;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.*;
import com.example.demo.service.RecommendationEngineService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service   // <-- critical annotation
@Transactional
public class RecommendationEngineServiceImpl implements RecommendationEngineService {

    private final PurchaseIntentRecordRepository purchaseIntentRepository;
    private final UserProfileRepository userProfileRepository;
    private final CreditCardRecordRepository creditCardRepository;
    private final RewardRuleRepository rewardRuleRepository;
    private final RecommendationRecordRepository recommendationRecordRepository;

    public RecommendationEngineServiceImpl(
            PurchaseIntentRecordRepository purchaseIntentRepository,
            UserProfileRepository userProfileRepository,
            CreditCardRecordRepository creditCardRepository,
            RewardRuleRepository rewardRuleRepository,
            RecommendationRecordRepository recommendationRecordRepository) {
        this.purchaseIntentRepository = purchaseIntentRepository;
        this.userProfileRepository = userProfileRepository;
        this.creditCardRepository = creditCardRepository;
        this.rewardRuleRepository = rewardRuleRepository;
        this.recommendationRecordRepository = recommendationRecordRepository;
    }

    @Override
    public RecommendationRecord generateRecommendation(Long intentId) {
        PurchaseIntentRecord intent = purchaseIntentRepository.findById(intentId)
                .orElseThrow(() -> new ResourceNotFoundException("Intent not found: " + intentId));

        UserProfile user = userProfileRepository.findById(intent.getUserId())
                .orElseThrow(() -> new ResourceNotFoundException("User not found: " + intent.getUserId()));

        if (user.getActive() != null && !user.getActive()) {
            throw new BadRequestException("User inactive");
        }

        List<CreditCardRecord> activeCards = creditCardRepository.findActiveCardsByUser(user.getId());
        if (activeCards.isEmpty()) {
            throw new BadRequestException("No active cards available");
        }

        RecommendationRecord bestRec = null;
        double bestReward = -1;

        for (CreditCardRecord card : activeCards) {
            List<RewardRule> rules = rewardRuleRepository.findActiveRulesForCardCategory(card.getId(), intent.getCategory());
            for (RewardRule rule : rules) {
                double reward = intent.getAmount() * rule.getMultiplier();
                if (reward > bestReward) {
                    bestReward = reward;
                    bestRec = new RecommendationRecord();
                    bestRec.setUserId(user.getId());
                    bestRec.setPurchaseIntentId(intent.getId());
                    bestRec.setRecommendedCardId(card.getId());
                    bestRec.setExpectedRewardValue(reward);
                    bestRec.setCalculationDetailsJson("{\"amount\":" + intent.getAmount() +
                            ",\"category\":\"" + intent.getCategory() +
                            "\",\"recommendedCardId\":" + card.getId() +
                            ",\"expectedReward\":" + reward + "}");
                    bestRec.prePersist();
                }
            }
        }

        if (bestRec == null) {
            throw new BadRequestException("No applicable reward rule found");
        }

        return recommendationRecordRepository.save(bestRec);
    }

    @Override
    public RecommendationRecord getRecommendationById(Long id) {
        return recommendationRecordRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Recommendation not found: " + id));
    }

    @Override
    public List<RecommendationRecord> getRecommendationsByUser(Long userId) {
        return recommendationRecordRepository.findByUserId(userId);
    }

    @Override
    public List<RecommendationRecord> getAllRecommendations() {
        return recommendationRecordRepository.findAll();
    }
}
