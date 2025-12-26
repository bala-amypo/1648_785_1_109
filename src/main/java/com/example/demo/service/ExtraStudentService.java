package com.example.demo.service;

import com.example.demo.entity.ExtraStudent;

public interface ExtraStudentService {
    ExtraStudent saveExtraStudent(ExtraStudent student);
    ExtraStudent CheckEmail(String email);
}