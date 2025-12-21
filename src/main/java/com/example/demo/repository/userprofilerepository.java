package com.example.demo.repository;

import com.example.demo.entity.userprofile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface userprofilerepository extends JpaRepository<userprofile, Long> {
 Optional<userprofile> findByUserId(String userId);
}
