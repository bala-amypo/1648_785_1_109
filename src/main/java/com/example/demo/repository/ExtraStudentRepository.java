package com.example.demo.repository;

import com.example.demo.entity.ExtraStudent;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface ExtraStudentRepository extends JpaRepository<ExtraStudent, Long> {
    Optional<ExtraStudent> findByEmail(String email);
}