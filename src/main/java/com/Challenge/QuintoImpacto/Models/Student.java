package com.Challenge.QuintoImpacto.Models;

import com.Challenge.QuintoImpacto.DTOS.StudentDTO;
import org.hibernate.annotations.GenericGenerator;
import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name="native", strategy = "native")
    private long id;

    @OneToMany(mappedBy = "student",fetch = FetchType.EAGER)
    private Set<StudentCourse> courses = new HashSet<>();

    private String name;
    private String lastName;

    private int age;
//    private LocalDate dateOfBirth;

    private LocalDate dateOfBirth;

    private String email;
    private String password;

;

    public Student() {
    }

    public Student(String name,String lastName, int age, LocalDate dateOfBirth,String email, String password){

        this.name = name;
        this.lastName = lastName;
        this.age = age;
        this.dateOfBirth = dateOfBirth;
        this.email = email;
        this.password = password;


    }



    public long getId() {
        return id;
    }

    public Set<StudentCourse> getCourses() {
        return courses;
    }

    public void setCourses(Set<StudentCourse> courses) {
        this.courses = courses;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
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

    public void addCourse(Course course1) {
    }
}