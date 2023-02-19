package com.Challenge.QuintoImpacto.Controllers;


import com.Challenge.QuintoImpacto.DTOS.StudentDTO;
import com.Challenge.QuintoImpacto.Models.Course;
import com.Challenge.QuintoImpacto.Models.CourseName;
import com.Challenge.QuintoImpacto.Models.Professor;
import com.Challenge.QuintoImpacto.Models.Student;
import com.Challenge.QuintoImpacto.Services.CourseService;
import com.Challenge.QuintoImpacto.Services.ProfessorService;
import com.Challenge.QuintoImpacto.Services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;

import static java.util.stream.Collectors.toList;


@RestController
public class StudentController  {
    @Autowired
    private StudentService studentService;

    @Autowired
    private ProfessorService professorService;
    @Autowired
    private CourseService courseService;

    @Autowired
    private PasswordEncoder passwordEncoder;


    @GetMapping("/api/student/{id}")
    public StudentDTO getStudents(@PathVariable Long id) {
        return new StudentDTO(studentService.getStudentById(id));
    }

    @GetMapping ("/api/student")
    public List<StudentDTO> getStudents(){
        return studentService.getAllStudents().stream().map(student -> new StudentDTO(student)).collect(toList());
    }

    @PostMapping("/api/registerStudent")
    public ResponseEntity<Object> registrarAlumno(@RequestParam String name,@RequestParam String lastName, @RequestParam int age, @RequestParam String dateOfBirth,@RequestParam String email, @RequestParam String password) {

        if (name.isEmpty()) {
            return new ResponseEntity<>("Introduce tu nombre", HttpStatus.FORBIDDEN);
        }
        if (age <= 0) {
            return new ResponseEntity<>("Debes ingresar tu edad", HttpStatus.FORBIDDEN);
        }
        if (dateOfBirth == null) {
            return new ResponseEntity<>("Introduce tu fecha de nacimiento", HttpStatus.FORBIDDEN);
        }
       LocalDate localDateParse = LocalDate.parse(dateOfBirth);


        Professor professor1 = new Professor("Camila","Fabiani");
        professorService.saveProfessor((professor1));

        Course course1 = new Course (CourseName.DISEÑO_WEB, "tarde", "17hs",professor1);
        courseService.saveCourse(course1);
        Course course2 = new Course (CourseName.DISEÑO_WEB, "tarde", "17hs",professor1);
        courseService.saveCourse(course2);

        Student registeredStudent = new Student(name,lastName, age,localDateParse,email,passwordEncoder.encode(password));
        studentService.saveStudent(registeredStudent);

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PatchMapping("/api/deleteStudent")
    public ResponseEntity<?> deleteStudent(@RequestParam Long id) {
        Student studentDelete = studentService.findById(id);

//        Set<Card> cardCurrent = clientCurrent.getCards();

        if ( studentDelete == null ) {
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }
        if ( id == 0 ) {
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }
        if ( id == null ) {
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }
        Student deleteStudent = studentService.findById(id);
        if ( deleteStudent == null ) {
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }
//        studentDelete.setEnabled(false);
        studentService.saveStudent(deleteStudent);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @GetMapping("/student/current")
    public StudentDTO getCurrentStudent(Authentication authentication) {
        return new StudentDTO(studentService.findByEmail(authentication.getName()));
    }
}