package com.Challenge.QuintoImpacto.Models;

import org.hibernate.annotations.GenericGenerator;
import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private long id;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "professor_id")
    private Professor professor;

    @OneToMany(mappedBy = "course",fetch = FetchType.EAGER)
    private Set<StudentCourse> studentCourses = new HashSet<>();
    private CourseName name;

    private String schedule;

    private String description;


    public Course() {
    }

    public Course(CourseName name, String schedule, String description,Professor professor) {
        this.name = name;
        this.schedule = schedule;
        this.description = description;
        this.professor = professor;

    }
    public Course(CourseName name, String schedule, String description) {
        this.name = name;
        this.schedule = schedule;
        this.description = description;


    }


    public long getId() {
        return id;
    }

    public Set<StudentCourse> getStudentCourses() {
        return studentCourses;
    }

    public void setStudentCourses(Set<StudentCourse> studentCourses) {
        this.studentCourses = studentCourses;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
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

//    public void addProfessor(Professor professor1) {
//    }
//    public void addStudent(Student student) {
//        this.studentList.add(student);
//    }
    public void addCourse(StudentCourse studentCourse){
    studentCourse.setCourse(this);
    studentCourses.add(studentCourse);

}
}