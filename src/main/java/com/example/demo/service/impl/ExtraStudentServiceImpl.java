package com.example.demo.service;

import com.example.demo.entity.ExtraStudent;
import com.example.demo.repository.ExtraStudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExtraStudentServiceImpl implements ExtraStudentService {

    @Autowired
    private ExtraStudentRepo repo;

    @Override
    public ExtraStudent saveExtraStudent(ExtraStudent student) {
        return repo.save(student);
    }

    @Override
    public ExtraStudent CheckEmail(String email) {
        return repo.findByEmail(email).orElse(null);
    }
}