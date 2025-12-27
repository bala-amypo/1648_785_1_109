package com.example.demo.service.impl;

import com.example.demo.entity.*;
import com.example.demo.exception.BadRequestException;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.*;
import com.example.demo.service.RecommendationEngineService;
import org.springframework.transaction.annotation.Transactional;

import java.util.Comparator;
import java.util.List;

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

    if (user.getActive() != null && !user.getActive())
      throw new BadRequestException("User inactive");

    List<CreditCardRecord> activeCards = creditCardRepository.findActiveCardsByUser(user.getId());
    if (activeCards.isEmpty())
      throw new BadRequestException("No active cards available");

    class Candidate {
      Long cardId; double reward;
      Candidate(Long cardId, double reward) { this.cardId = cardId; this.reward = reward; }
    }

    Candidate best = null;
    for (CreditCardRecord card : activeCards) {
      List<RewardRule> rules = rewardRuleRepository
          .findActiveRulesForCardCategory(card.getId(), intent.getCategory());
      for (RewardRule rule : rules) {
        double value = intent.getAmount() * rule.getMultiplier();
        if (best == null || value > best.reward) best = new Candidate(card.getId(), value);
      }
    }

    if (best == null) throw new BadRequestException("No applicable reward rule found");

    RecommendationRecord rec = new RecommendationRecord();
    rec.setUserId(user.getId());
    rec.setPurchaseIntentId(intent.getId());
    rec.setRecommendedCardId(best.cardId);
    rec.setExpectedRewardValue(Math.max(0.0, best.reward));
    rec.setCalculationDetailsJson("{\"amount\":" + intent.getAmount() +
        ",\"category\":\"" + intent.getCategory() +
        "\",\"recommendedCardId\":" + best.cardId +
        ",\"expectedReward\":" + best.reward + "}");
    rec.prePersist();
    return recommendationRecordRepository.save(rec);
  }

  @Override
  public RecommendationRecord getRecommendationById(Long id) {
    return recommendationRecordRepository.findById(id).orElseThrow(() ->
        new ResourceNotFoundException("Recommendation not found: " + id));
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
