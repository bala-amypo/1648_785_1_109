package com.example.demo.repository;

import com.example.demo.entity.userprofile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Repository;
import java.util.Optional;
@Repository
public interface userprofilerepository extends JpaRepository<userprofile, Long> {

}