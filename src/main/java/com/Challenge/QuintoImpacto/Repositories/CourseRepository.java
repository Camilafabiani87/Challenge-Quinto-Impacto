package com.Challenge.QuintoImpacto.Repositories;

import com.Challenge.QuintoImpacto.Models.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface CourseRepository extends JpaRepository<Course, Long> {


}