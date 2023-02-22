package com.Challenge.QuintoImpacto.Services;

import com.Challenge.QuintoImpacto.Models.Professor;
import java.util.List;

public interface ProfessorService {
    List<Professor> getAllProfessors();
    void saveProfessor(Professor professor);
    Professor findByEmail(String email);
    Professor findById(long id);



}