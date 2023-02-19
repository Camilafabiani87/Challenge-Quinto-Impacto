package com.Challenge.QuintoImpacto.DTOS;

        import com.Challenge.QuintoImpacto.Models.CourseName;
        import com.Challenge.QuintoImpacto.Models.Student;
        import com.Challenge.QuintoImpacto.Models.StudentCourse;

        import java.time.LocalDate;
        import java.time.LocalDateTime;
        import java.util.HashSet;
        import java.util.Set;
        import java.util.stream.Collectors;

public class StudentDTO {
    private long id;
    private String name;
    private String lastName;
    private int age;
    private LocalDate dateOfBirth;
    private String email;
    private String password;
    private Set<CourseName> courses = new HashSet<>();


    public StudentDTO() {
    }

    public StudentDTO(Student student) {
        this.id = student.getId();
        this.name = student.getName();
        this.lastName = student.getLastName();
        this.age = student.getAge();
        this.dateOfBirth = student.getDateOfBirth();
        this.email = student.getEmail();
        this.password = student.getPassword();
        this.courses = student.getCourses().stream().map(studentCourse -> studentCourse.getCourse().getName()).collect(Collectors.toSet());
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
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

    public Set<CourseName> getCourses() {
        return courses;
    }

    public void setCourses(Set<CourseName> courses) {
        this.courses = courses;
    }
}