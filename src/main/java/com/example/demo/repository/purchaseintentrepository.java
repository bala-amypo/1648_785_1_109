package com.example.demo.repository;

import com.example.demo.entity.purchaseintent;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface purchaseintentrepository
        extends JpaRepository<purchaseintent, Long> {

    List<purchaseintent> findByUserId(Long userId);
}
