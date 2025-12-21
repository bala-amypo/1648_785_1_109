package com.example.demo.repository;

import com.example.demo.entity.rewardrule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface rewardrulerepository extends JpaRepository<rewardrule, Long> {
    @Query("SELECT r FROM rewardrule r WHERE r.active = true")
    List<rewardrule> findByActiveTrue();
}
