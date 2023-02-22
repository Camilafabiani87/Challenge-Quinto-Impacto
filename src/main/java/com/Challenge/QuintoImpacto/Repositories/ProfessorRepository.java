package com.Challenge.QuintoImpacto.Repositories;

import com.Challenge.QuintoImpacto.Models.Professor;
import com.Challenge.QuintoImpacto.Models.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface ProfessorRepository extends JpaRepository<Professor,Long> {
    Professor findByEmail(String email);
    Professor findById(long id);


}