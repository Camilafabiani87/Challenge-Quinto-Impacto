package com.Challenge.QuintoImpacto.DTOS;

import com.Challenge.QuintoImpacto.Models.CourseName;
import com.Challenge.QuintoImpacto.Models.Professor;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class ProfessorDTO {
    private long id;

    private String professorName;

    private String professorLastname;


    private Set<CourseDTO> courses = new HashSet<>();

    public ProfessorDTO() {
    }

    public ProfessorDTO(Professor professor) {
        this.id = professor.getId();
        this.professorName = professor.getProfessorName();
        this.professorLastname = professor.getProfessorLastname();
        this.courses = professor.getCourse().stream().map(course -> new CourseDTO(course)).collect(Collectors.toSet());
    }

    public long getId() {
        return id;
    }

    public String getProfessorName() {
        return professorName;
    }

    public void setProfessorName(String professorName) {
        this.professorName = professorName;
    }

    public String getProfessorLastname() {
        return professorLastname;
    }

    public void setProfessorLastname(String professorLastname) {
        this.professorLastname = professorLastname;
    }


    public Set<CourseDTO> getCourses() {
        return courses;
    }

    public void setCourses(Set<CourseDTO> courses) {
        this.courses = courses;
    }
}