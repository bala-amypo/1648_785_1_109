public interface RewardRuleRepository extends JpaRepository<RewardRule, Long> {
    List<RewardRule> findByActiveTrue();
    List<RewardRule> findActiveRulesForCardCategory(Long cardId, String category);
}
