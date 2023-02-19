package com.Challenge.QuintoImpacto.Repositories;

import com.Challenge.QuintoImpacto.Models.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface StudentRepository extends JpaRepository<Student,Long> {

    Student findById(long id);
    Student findByName(String name);
    Student findByEmail(String email);
}