package com.example.OneToMany.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.example.OneToMany.entity.ExtraStudent;
import com.example.OneToMany.repository.ExtraStudentRepo;
import com.example.OneToMany.service.ExtraStudentService;

@Service
public class ExtraStudentServiceImpl implements ExtraStudentService {

    @Autowired
    ExtraStudentRepo repo;

    @Override
    public ExtraStudent saveExtraStudent(ExtraStudent stu) {
        return repo.save(stu);
    }
}