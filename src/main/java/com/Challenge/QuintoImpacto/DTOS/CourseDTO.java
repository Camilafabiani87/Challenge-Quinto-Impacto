package com.Challenge.QuintoImpacto.DTOS;

import com.Challenge.QuintoImpacto.Models.Course;
import com.Challenge.QuintoImpacto.Models.CourseName;
import com.Challenge.QuintoImpacto.Models.Professor;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class CourseDTO{
    private Long id;
    private String professor;
    private CourseName name;
    private String schedule;
    private String description;

    private Set<StudentDTO> studentsDTO = new HashSet<>();


    public CourseDTO() {
    }

    public CourseDTO(Course course) {
        this.id = course.getId();
        this.name = course.getName();
        this.schedule = course.getSchedule();
        this.studentsDTO = course.getStudentCourses().stream().map(studentCourse-> new StudentDTO(studentCourse.getStudent())).collect(Collectors.toSet());
        if( course.getProfessor() == null)  {
            this.professor = "No hay profesor para este curso";
        }else {
            this.professor = course.getProfessor().getProfessorName() + " " + course.getProfessor().getProfessorLastname();

        }
        this.description = course.getDescription();
    }

    public Long getId() {
        return id;
    }

    public String getProfessor() {
        return professor;
    }

    public void setProfessor(String professor) {
        this.professor = professor;
    }

    public CourseName getName() {
        return name;
    }

    public void setName(CourseName name) {
        this.name = name;
    }

    public String getSchedule() {
        return schedule;
    }

    public void setSchedule(String schedule) {
        this.schedule = schedule;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<StudentDTO> getStudentsDTO() {
        return studentsDTO;
    }

    public void setStudentsDTO(Set<StudentDTO> studentsDTO) {
        this.studentsDTO = studentsDTO;
    }
}