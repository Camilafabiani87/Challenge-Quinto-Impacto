package com.Challenge.QuintoImpacto.Services.Implements;

import com.Challenge.QuintoImpacto.DTOS.CourseDTO;
import com.Challenge.QuintoImpacto.Models.Course;
import com.Challenge.QuintoImpacto.Models.CourseName;
import com.Challenge.QuintoImpacto.Repositories.CourseRepository;
import com.Challenge.QuintoImpacto.Services.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
@Service
public class CourseServiceImplement implements CourseService {
    @Autowired
    CourseRepository courseRepository;
    @Override
    public Course findById(long id) {
        return courseRepository.findById(id);
    }
    @Override
    public Course findByName(CourseName name) {
            return courseRepository.findByName(name);
        }
    @Override
    public void saveCourse(Course course) {
        courseRepository.save(course);
    }

    @Override
    public List<Course> getAllCourses(){return courseRepository.findAll();}
    @Override
    public Set<CourseDTO> getCoursesDTO() {
        return courseRepository.findAll().stream().map(course -> new CourseDTO(course)).collect(Collectors.toSet());
    }

}