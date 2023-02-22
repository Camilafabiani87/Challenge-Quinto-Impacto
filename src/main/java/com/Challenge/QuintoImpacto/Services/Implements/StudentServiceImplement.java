package com.Challenge.QuintoImpacto.Services.Implements;

import com.Challenge.QuintoImpacto.Models.Student;
import com.Challenge.QuintoImpacto.Repositories.StudentRepository;
import com.Challenge.QuintoImpacto.Services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class StudentServiceImplement implements StudentService {
    @Autowired
    StudentRepository studentRepository;
    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }
    @Override
    public Student getStudentById(long id) {
        return studentRepository.findById(id);
    }
    @Override
    public void saveStudent(Student student) {
        studentRepository.save(student);
    }
    @Override
    public Student findByEmail(String email) {return studentRepository.findByEmail((email));}
    @Override
    public Student findById(long id) {
        return studentRepository.findById(id);
    }
}