package com.Challenge.QuintoImpacto.Services;

import com.Challenge.QuintoImpacto.Models.Professor;
import com.Challenge.QuintoImpacto.Models.Student;

import java.util.List;

public interface ProfessorService {

    List<Professor> getAllProfessors();
//    Professor getProfessorById(long id);
    void saveProfessor(Professor professor);
    public Professor findByEmail(String email);
    public Professor findById(long id);



}