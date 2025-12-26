package com.example.demo.service;

import com.example.demo.entity.ExtraStudent;
import com.example.demo.repository.ExtraStudentRepository; // You will need a repository too
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service // This is the crucial annotation!
public class ExtraStudentServiceImpl implements ExtraStudentService {

    @Autowired
    private ExtraStudentRepository repository;

    @Override
    public ExtraStudent saveExtraStudent(ExtraStudent student) {
        return repository.save(student);
    }

    @Override
    public ExtraStudent CheckEmail(String email) {
        // This assumes your repository has a findByEmail method
        return repository.findByEmail(email).orElse(null);
    }
}