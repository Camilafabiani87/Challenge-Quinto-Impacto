package com.Challenge.QuintoImpacto.Controllers;

import com.Challenge.QuintoImpacto.DTOS.StudentDTO;
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
import java.util.List;
import static java.util.stream.Collectors.toList;


@RestController
public class StudentController {
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

    @GetMapping("/api/student")
    public List<StudentDTO> getStudents() {
        return studentService.getAllStudents().stream().filter(student -> student.isEnabled()).map(student -> new StudentDTO(student)).collect(toList());
    }

    @PostMapping("/api/registerStudent")
    public ResponseEntity<Object> registrarStudent(@RequestParam String name, @RequestParam String lastName, @RequestParam String email, @RequestParam String password) {

        if ( name.isEmpty() ) {
            return new ResponseEntity<>("Introduce tu nombre", HttpStatus.FORBIDDEN);
        }
        if ( lastName.isEmpty() ) {
            return new ResponseEntity<>("Introduce tu apellido", HttpStatus.FORBIDDEN);
        }
        if ( email.isEmpty() ) {
            return new ResponseEntity<>("Introduce tu email", HttpStatus.FORBIDDEN);
        }
        if ( password.isEmpty() ) {
            return new ResponseEntity<>("Introduce tu contraseña", HttpStatus.FORBIDDEN);
        }


        Student registeredStudent = new Student(name, lastName, email, passwordEncoder.encode(password));
        studentService.saveStudent(registeredStudent);

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PatchMapping("/api/deleteStudent")
    public ResponseEntity<?> deleteStudent(@RequestParam Long id) {
        Student studentDelete = studentService.findById(id);

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
        studentDelete.setEnabled(false);
        studentService.saveStudent(deleteStudent);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/api/student/current")
    public StudentDTO getCurrentStudent(Authentication authentication) {
        return new StudentDTO(studentService.findByEmail(authentication.getName()));
    }


}