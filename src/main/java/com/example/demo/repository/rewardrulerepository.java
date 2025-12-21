package com.example.demo.repository;

import com.example.demo.entity.rewardrule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface rewardrulerepository extends JpaRepository<rewardrule, Long> {

    List<rewardrule> findByCardId(Long cardId);

    List<rewardrule> findByActiveTrue();
}
