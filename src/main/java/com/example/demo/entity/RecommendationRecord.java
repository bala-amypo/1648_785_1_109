@Entity
public class RecommendationRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long userId;
    private Long purchaseIntentId;
    private Long recommendedCardId;
    private double expectedRewardValue;
    private String calculationDetailsJson;

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public void setPurchaseIntentId(Long purchaseIntentId) {
        this.purchaseIntentId = purchaseIntentId;
    }

    public void setRecommendedCardId(Long recommendedCardId) {
        this.recommendedCardId = recommendedCardId;
    }

    public void setExpectedRewardValue(double expectedRewardValue) {
        this.expectedRewardValue = expectedRewardValue;
    }

    public void setCalculationDetailsJson(String calculationDetailsJson) {
        this.calculationDetailsJson = calculationDetailsJson;
    }
}
find src/main/java -name "*CreditCardRecord*.java"
find src/main/java -name "*RewardRule*.java"
find src/main/java -name "*RecommendationRecord*.java"
