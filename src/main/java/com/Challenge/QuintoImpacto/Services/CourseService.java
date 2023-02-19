package com.Challenge.QuintoImpacto.Services;

import com.Challenge.QuintoImpacto.Models.Course;
import java.util.List;


public interface CourseService {

        List<Course> getAllCourses ();
        Course getCourseById(long id);
        void saveCourse(Course course);


}