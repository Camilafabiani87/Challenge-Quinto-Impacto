package com.Challenge.QuintoImpacto.Services.Implements;

import com.Challenge.QuintoImpacto.Models.Professor;
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
    public Professor getProfessorById(long id) {
        return professorRepository.findById(id).get();
    }

    @Override
    public void saveProfessor(Professor professor) {
        professorRepository.save(professor);
    }


}