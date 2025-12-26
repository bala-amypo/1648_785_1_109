package com.example.demo.repository;

import com.example.demo.entity.*;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.*;

public interface PurchaseIntentRecordRepository extends JpaRepository<PurchaseIntentRecord, Long> {
    List<PurchaseIntentRecord> findByUserId(Long userId);
}
