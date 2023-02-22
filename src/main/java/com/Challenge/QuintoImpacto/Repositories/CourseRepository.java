package com.Challenge.QuintoImpacto.Repositories;

import com.Challenge.QuintoImpacto.Models.Course;
import com.Challenge.QuintoImpacto.Models.CourseName;
import com.Challenge.QuintoImpacto.Models.Professor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface CourseRepository extends JpaRepository<Course, Long> {
    Course findById(long id);
    Course findByName(CourseName name);


}