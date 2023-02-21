package com.Challenge.QuintoImpacto.Models;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
public class StudentCourse  {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name="native", strategy = "native")
    private long id;
//    private CourseName name;
//
//    private Student studentCurrent;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "student_id")
    private Student student;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "course_id")
    private Course course;

    public StudentCourse() {
    }

    public StudentCourse(Student student, Course course) {
        this.student = student;
        this.course = course;
    }

//    public StudentCourse(CourseName name,Student studentCurrent, Course course) {
//        this.name = name;
//        this.studentCurrent = studentCurrent;
//        this.course = course;
//    }



    public long getId() {
        return id;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }
}