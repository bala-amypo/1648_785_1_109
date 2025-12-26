package com.example.OneToMany.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.OneToMany.entity.ExtraStudent;

@Repository
public interface ExtraStudentRepository extends JpaRepository<ExtraStudent, Long> {


}