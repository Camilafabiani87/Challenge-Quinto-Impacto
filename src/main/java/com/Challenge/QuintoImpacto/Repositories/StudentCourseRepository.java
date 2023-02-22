package com.Challenge.QuintoImpacto.Repositories;


import com.Challenge.QuintoImpacto.Models.StudentCourse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface StudentCourseRepository extends JpaRepository<StudentCourse,Long> {

}