package com.Challenge.QuintoImpacto.Controllers;

import com.Challenge.QuintoImpacto.DTOS.CourseDTO;
import com.Challenge.QuintoImpacto.DTOS.ProfessorDTO;
import com.Challenge.QuintoImpacto.Models.Course;
import com.Challenge.QuintoImpacto.Models.Student;
import com.Challenge.QuintoImpacto.Models.StudentCourse;
import com.Challenge.QuintoImpacto.Repositories.CourseRepository;
import com.Challenge.QuintoImpacto.Services.CourseService;
import com.Challenge.QuintoImpacto.Services.StudentCourseService;
import com.Challenge.QuintoImpacto.Services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/api")
public class CourseController{
    @Autowired
    CourseService courseService;
    @Autowired
    StudentService studentService;
    @Autowired
    StudentCourseService studentCourseService;

    @GetMapping("/courses")
    public Set<CourseDTO> getCourses(){
        return courseService.getCoursesDTO();
    }
    @Transactional
    @PostMapping("/courses")
    public ResponseEntity<?> inscriptionCourse(Authentication authentication, @RequestBody CourseDTO courseDTO) {
        Student studentCurrent = studentService.findByEmail(authentication.getName());
        if ( studentCurrent != null ) {
            Course course = courseService.getCourseById(courseDTO.getId());

            Set<Course> courseStudentCurrent = studentCurrent.getCourses().stream().map(courseStudent -> courseStudent.getCourse()).collect(Collectors.toSet());
            if(courseStudentCurrent.contains(course)){
            return new ResponseEntity<>("Ya estas inscripto a este curso",HttpStatus.FORBIDDEN);
        }
            if ( course == null ) {
                return new ResponseEntity<>("El curso solicitado no existe", HttpStatus.FORBIDDEN);
            }

            StudentCourse studentCourse = new StudentCourse(studentCurrent,course);
            studentCourseService.saveStudentCourse((studentCourse));


            return new ResponseEntity<>(HttpStatus.CREATED);
        }
        return new ResponseEntity<>("Para inscribirte debes estar autenticado", HttpStatus.FORBIDDEN);
    }
}