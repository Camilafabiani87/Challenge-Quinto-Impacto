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
    private String email;
    private String password;
    private Set<CourseName> courses = new HashSet<>();
    private boolean enabled;
    public ProfessorDTO() {
    }
    public ProfessorDTO(Professor professor) {
        this.id = professor.getId();
        this.professorName = professor.getProfessorName();
        this.professorLastname = professor.getProfessorLastname();
        this.courses = professor.getCourse().stream().map(professorCourse -> professorCourse.getName()).collect(Collectors.toSet());
        this.email = professor.getEmail();
        this.password = professor.getPassword();
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
    public Set<CourseName> getCourses() {
        return courses;
    }
    public void setCourses(Set<CourseName> courses) {
        this.courses = courses;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public boolean isEnabled() {
        return enabled;
    }
    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }
}