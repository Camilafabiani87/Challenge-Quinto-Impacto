package com.Challenge.QuintoImpacto.Services.Implements;

import com.Challenge.QuintoImpacto.Models.StudentCourse;
import com.Challenge.QuintoImpacto.Repositories.StudentCourseRepository;
import com.Challenge.QuintoImpacto.Services.StudentCourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentCourseImplement implements StudentCourseService {
    @Autowired
    StudentCourseRepository studentCourseRepository;
    @Override
    public void saveStudentCourse(StudentCourse studentCourse) {
        studentCourseRepository.save(studentCourse);
    }
}
