package com.Challenge.QuintoImpacto.Services;

import java.util.List;
import com.Challenge.QuintoImpacto.Models.Student;

public interface StudentService{

     List<Student> getAllStudents();
     Student getStudentById(long id);
     void saveStudent(Student student);
     public Student findByEmail(String Email);

     public Student findById(long id);
}