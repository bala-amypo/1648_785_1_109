
package com.example.demo.repository;

import com.example.demo.entity.CreditCardRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

public interface CreditCardRecordRepository extends JpaRepository<CreditCardRecord, Long> {
    List<CreditCardRecord> findByUserId(Long userId);
    @Query("SELECT c FROM CreditCardRecord c WHERE c.userId = ?1 AND c.status = 'ACTIVE'")
    List<CreditCardRecord> findActiveCardsByUser(Long userId);
}


package com.example.demo.repository;

import com.example.demo.entity.RecommendationRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface RecommendationRecordRepository extends JpaRepository<RecommendationRecord, Long> {
    List<RecommendationRecord> findByUserId(Long userId);
}

package com.example.demo.repository;

import com.example.demo.entity.RewardRule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

public interface RewardRuleRepository extends JpaRepository<RewardRule, Long> {
    List<RewardRule> findByActiveTrue();
    @Query("SELECT r FROM RewardRule r WHERE r.cardId = ?1 AND r.category = ?2 AND r.active = true")
    List<RewardRule> findActiveRulesForCardCategory(Long cardId, String category);
}


package com.example.demo.repository;

import com.example.demo.entity.UserProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface UserProfileRepository extends JpaRepository<UserProfile, Long> {
    boolean existsByEmail(String email);
    boolean existsByUserId(String userId);
    Optional<UserProfile> findByEmail(String email);
}