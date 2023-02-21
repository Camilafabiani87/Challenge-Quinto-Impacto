package com.Challenge.QuintoImpacto.Services.Implements;

import com.Challenge.QuintoImpacto.Models.Professor;
import com.Challenge.QuintoImpacto.Models.Student;
import com.Challenge.QuintoImpacto.Repositories.ProfessorRepository;
import com.Challenge.QuintoImpacto.Services.ProfessorService;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

@Service
public class ProfessorServiceImplement implements ProfessorService {

    @Autowired
    ProfessorRepository professorRepository;

    @Override
    public List<Professor> getAllProfessors() {
        return professorRepository.findAll();
    }


    @Override
    public void saveProfessor(Professor professor) {
        professorRepository.save(professor);
    }

    @Override
    public Professor findByEmail(String email) {
        return professorRepository.findByEmail(email);
    }

    @Override
    public Professor findById(long id) {
        return professorRepository.findById(id);
    }


}