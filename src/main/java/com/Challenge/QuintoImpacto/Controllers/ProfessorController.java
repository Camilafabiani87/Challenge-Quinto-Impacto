package com.Challenge.QuintoImpacto.Controllers;


import com.Challenge.QuintoImpacto.DTOS.ProfessorDTO;
import com.Challenge.QuintoImpacto.Services.ProfessorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import static java.util.stream.Collectors.toList;

@RestController
public class ProfessorController {

    @Autowired
    private ProfessorService professorService;



    @GetMapping("/api/professor/{id}")
    public ProfessorDTO getProfessor(@PathVariable Long id){
        return new ProfessorDTO(professorService.getProfessorById(id));
    }

    @GetMapping ("/api/professor")
    public List<ProfessorDTO> getProfessor(){
        return professorService.getAllProfessors().stream().map(professor  -> new ProfessorDTO(professor)).collect(toList());
    }


    //Registrar un profesor
    @PostMapping("/api/professor/registration")
    public ResponseEntity<Object> professorRegistration(@RequestParam String professorName,@RequestParam String professorLastname,@RequestParam String courseName) {

        if (professorName.isEmpty()) {
            return new ResponseEntity<>("Introduce tu nombre Profesor", HttpStatus.FORBIDDEN);
        }
        if (professorLastname.isEmpty()) {
            return new ResponseEntity<>("Introduce tu apellido Profesor", HttpStatus.FORBIDDEN);
        }




        return new ResponseEntity<>(HttpStatus.CREATED);

    }



}