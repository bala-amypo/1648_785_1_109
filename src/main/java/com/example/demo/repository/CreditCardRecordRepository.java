package com.example.demo.repository;

import com.example.demo.entity.*;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.*;
public interface CreditCardRecordRepository extends JpaRepository<CreditCardRecord, Long> {
    List<CreditCardRecord> findByUserId(Long userId);
    List<CreditCardRecord> findActiveCardsByUser(Long userId);
}
