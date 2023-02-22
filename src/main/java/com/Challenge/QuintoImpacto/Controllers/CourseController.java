package com.Challenge.QuintoImpacto.Controllers;

import com.Challenge.QuintoImpacto.DTOS.CourseDTO;
import com.Challenge.QuintoImpacto.DTOS.ProfessorDTO;
import com.Challenge.QuintoImpacto.Models.*;
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

import static java.util.stream.Collectors.toList;


@RestController
@RequestMapping("/api")
public class CourseController{
    @Autowired
    CourseService courseService;
    @Autowired
    StudentService studentService;
    @Autowired
    StudentCourseService studentCourseService;

//    @GetMapping("/courses")
//    public Set<CourseDTO> getCourses(){
//        return courseService.getCoursesDTO();
//    }


    @GetMapping ("/courses")
    public List<CourseDTO> getCourses(){
        return courseService.getAllCourses().stream().filter(course -> course.isEnabled()).map(course  -> new CourseDTO(course)).collect(toList());
    }
    @Transactional
    @PostMapping("/courses")
    public ResponseEntity<?> inscriptionCourse(Authentication authentication, @RequestBody CourseDTO courseDTO) {
        Student studentCurrent = studentService.findByEmail(authentication.getName());
        if ( studentCurrent != null ) {
            Course course = courseService.findById(courseDTO.getId());

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
    @PostMapping("/createCourse")
    public ResponseEntity<?> createCourse(Authentication authentication, @RequestParam CourseName courseName) {
        Student adminCurrent = studentService.findByEmail(authentication.getName());
        if(courseName == null){
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }
        courseService.saveCourse(new Course(courseName));
            return new ResponseEntity<>("El curso se ha creado exitosamente", HttpStatus.CREATED);

    }
    @PatchMapping("/deleteCourse")
    public ResponseEntity<?> deleteCourse(@RequestParam Long id) {
        Course courseDelete = courseService.findById(id);

        if ( courseDelete == null ) {
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }
        if ( id == 0 ) {
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }
        if ( id == null ) {
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }
        Course deleteCourse = courseService.findById(id);
        if ( deleteCourse == null ) {
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }
        courseDelete.setEnabled(false);
        courseService.saveCourse(deleteCourse);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}