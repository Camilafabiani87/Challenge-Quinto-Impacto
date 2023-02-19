package com.Challenge.QuintoImpacto.Controllers;

import com.Challenge.QuintoImpacto.DTOS.CourseDTO;
import com.Challenge.QuintoImpacto.DTOS.ProfessorDTO;
import com.Challenge.QuintoImpacto.Repositories.CourseRepository;
import com.Challenge.QuintoImpacto.Services.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static java.util.stream.Collectors.toList;

@RestController
public class CourseController {
    @Autowired
    CourseService courseService;

//    @GetMapping("/api/course/{id}")
//    public CourseDTO getCourse(@PathVariable Long id){
//        return new CourseDTO(courseService.getProfessorById(id));
//    }
//
//    @GetMapping ("/api/professor")
//    public List<ProfessorDTO> getProfessor(){
//        return professorService.getAllProfessors().stream().map(professor  -> new ProfessorDTO(professor)).collect(toList());
//    }
}
