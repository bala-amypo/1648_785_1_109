package com.example.demo.repository;

import com.example.demo.entity.purchaintentrepository;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface purchaintentrepository extends JpaRepository<creditcard, Long> {
    Optional<creditcard> findByUserId(Long userId);
}


public interface PurchaseIntentRecordRepository extends JpaRepository<PurchaseIntentRecord, Long> {
}
