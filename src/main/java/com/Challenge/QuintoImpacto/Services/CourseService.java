package com.Challenge.QuintoImpacto.Services;

import com.Challenge.QuintoImpacto.DTOS.CourseDTO;
import com.Challenge.QuintoImpacto.Models.Course;
import java.util.List;
import java.util.Set;


public interface CourseService {

        List<Course> getAllCourses ();
        Course getCourseById(long id);
        void saveCourse(Course course);

        public Set<CourseDTO> getCoursesDTO();


}