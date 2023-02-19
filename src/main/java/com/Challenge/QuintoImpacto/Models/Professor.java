package com.Challenge.QuintoImpacto.Models;

import org.hibernate.annotations.GenericGenerator;
import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Professor {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private long id;

    @OneToMany(mappedBy = "professor", fetch = FetchType.EAGER)
    private Set<Course> courses= new HashSet<>();
    private String professorName;

    private String professorLastname;


    public Professor() {
    }
    public Professor(String professorName, String professorLastname, Set<Course> courses){

        this.professorName = professorName;
        this.professorLastname = professorLastname;
        this.courses = courses;
    }
    public Professor(String professorName, String professorLastname) {

        this.professorName = professorName;
        this.professorLastname = professorLastname;

    }

    public long getId() {
        return id;
    }



    public Set<Course> getCourse() {
        return courses;
    }

    public void setCourse(Set<Course> courses) {
        this.courses = courses;
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


    public void addCourse(Course course){
        course.setProfessor(this);
        courses.add(course);
    }
}
