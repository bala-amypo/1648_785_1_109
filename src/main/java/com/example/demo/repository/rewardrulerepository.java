package com.example.demo.repository;

import com.example.demo.entity.userprofile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface RewardRuleRepository extends JpaRepository<RewardRule, Long> {
    @Query("SELECT r FROM RewardRule r WHERE r.active = true")
    List<RewardRule> findByActiveTrue();
}
