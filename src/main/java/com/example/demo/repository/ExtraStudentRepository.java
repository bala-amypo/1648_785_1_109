package com.example.demo.repository;

import com.example.demo.entity.ExtraStudent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface ExtraStudentRepo extends JpaRepository<ExtraStudent, Long> {
    Optional<ExtraStudent> findByEmail(String email);
}