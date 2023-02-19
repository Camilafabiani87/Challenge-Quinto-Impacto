package com.Challenge.QuintoImpacto.Repositories;

import com.Challenge.QuintoImpacto.Models.Professor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface ProfessorRepository extends JpaRepository<Professor,Long> {

    Professor findByProfessorName(String professorName);
}