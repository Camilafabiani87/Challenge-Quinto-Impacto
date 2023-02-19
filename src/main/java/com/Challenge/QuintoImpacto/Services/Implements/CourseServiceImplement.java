package com.Challenge.QuintoImpacto.Services.Implements;

import com.Challenge.QuintoImpacto.Models.Course;
import com.Challenge.QuintoImpacto.Repositories.CourseRepository;
import com.Challenge.QuintoImpacto.Services.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
public class CourseServiceImplement implements CourseService {

    @Autowired
    CourseRepository courseRepository;

    @Override
    public Course getCourseById(long id) {
        return courseRepository.findById(id).get();
    }

    @Override
    public void saveCourse(Course course) {
        courseRepository.save(course);
    }

    @Override
    public List<Course> getAllCourses(){

        return courseRepository.findAll();
    }
}