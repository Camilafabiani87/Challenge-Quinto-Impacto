package com.Challenge.QuintoImpacto.Controllers;

import com.Challenge.QuintoImpacto.DTOS.ProfessorDTO;
import com.Challenge.QuintoImpacto.Models.Course;
import com.Challenge.QuintoImpacto.Models.CourseName;
import com.Challenge.QuintoImpacto.Models.Professor;
import com.Challenge.QuintoImpacto.Services.CourseService;
import com.Challenge.QuintoImpacto.Services.ProfessorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static java.util.stream.Collectors.toList;

@RestController
public class ProfessorController {

    @Autowired
    private ProfessorService professorService;
    @Autowired
    private CourseService courseService;


    @GetMapping("/api/professor/{id}")
    public ProfessorDTO getProfessor(@PathVariable Long id) {
        return new ProfessorDTO(professorService.findById(id));
    }

    @GetMapping("/api/professor")
    public List<ProfessorDTO> getProfessor() {
        return professorService.getAllProfessors().stream().filter(professor -> professor.isEnabled()).map(professor -> new ProfessorDTO(professor)).collect(toList());
    }

    @PostMapping("/api/professor/registration")
    public ResponseEntity<Object> professorRegistration(@RequestParam String professorName, @RequestParam String professorLastname, @RequestParam String courseName) {

        if ( professorName.isEmpty() ) {
            return new ResponseEntity<>("Introduce tu nombre Profesor", HttpStatus.FORBIDDEN);
        }
        if ( professorLastname.isEmpty() ) {
            return new ResponseEntity<>("Introduce tu apellido Profesor", HttpStatus.FORBIDDEN);
        }


        return new ResponseEntity<>(HttpStatus.CREATED);

    }

    @PatchMapping("/api/deleteProfessor")
    public ResponseEntity<?> deleteProfessor(@RequestParam Long id) {
        Professor professorDelete = professorService.findById(id);

        if ( professorDelete == null ) {
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }
        if ( id == 0 ) {
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }
        if ( id == null ) {
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }
        Professor deleteProfessor = professorService.findById(id);
        if ( deleteProfessor == null ) {
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }
        professorDelete.setEnabled(false);
        professorService.saveProfessor(deleteProfessor);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/api/professor/current")
    public ProfessorDTO getCurrentProfessor(Authentication authentication) {
        return new ProfessorDTO(professorService.findByEmail(authentication.getName()));
    }

    @PatchMapping("/api/deleteCourseProfessor")
    public ResponseEntity<Object> deleteCourseProfessor(@RequestParam String name) {
        Course course = courseService.findByName(CourseName.valueOf(name));
        course.setProfessor(null);
        courseService.saveCourse(course);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}