package com.Challenge.QuintoImpacto.Services;

import com.Challenge.QuintoImpacto.DTOS.CourseDTO;
import com.Challenge.QuintoImpacto.Models.Course;
import com.Challenge.QuintoImpacto.Models.CourseName;
import java.util.List;
import java.util.Set;
public interface CourseService {
        List<Course> getAllCourses ();
        public Course findById(long id);
        Course findByName(CourseName name);
        void saveCourse(Course course);
        Set<CourseDTO> getCoursesDTO();
}