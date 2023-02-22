package com.Challenge.QuintoImpacto;

import com.Challenge.QuintoImpacto.Models.*;
import com.Challenge.QuintoImpacto.Repositories.CourseRepository;
import com.Challenge.QuintoImpacto.Repositories.ProfessorRepository;
import com.Challenge.QuintoImpacto.Repositories.StudentCourseRepository;
import com.Challenge.QuintoImpacto.Repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;
import java.time.LocalDate;

@SpringBootApplication
public class QuintoImpactoApplication {
    @Autowired
    private PasswordEncoder passwordEncoder;
    public static void main(String[] args) {
        SpringApplication.run(QuintoImpactoApplication.class, args);
    }
    @Bean
    public CommandLineRunner initData(StudentRepository studentRepository, CourseRepository courseRepository, StudentCourseRepository studentCourseRepository, ProfessorRepository professorRepository) {
        return args -> {

            Student admin = new Student("Admin", "Admin", 50, LocalDate.parse("1975-08-03"), "admin@admin.com", passwordEncoder.encode("123"));
            studentRepository.save(admin);

            Professor professor1 = new Professor("Gisela", "Ariza", "gi@gmail.com", passwordEncoder.encode("123"));
            Professor professor2 = new Professor("Camila", "Fabiani", "ca@gmail.com", passwordEncoder.encode("123"));
            Professor professor3 = new Professor("Pablo", "Ramirez", "pablo@gmail.com", passwordEncoder.encode("123"));

            professorRepository.save(professor1);
            professorRepository.save(professor2);
            professorRepository.save(professor3);

            Course course1 = new Course(CourseName.FOTOGRAFIA, "Horario Manana", "Curso de Fotografia intensivo, 5 semanas", professor1);
            Course course2 = new Course(CourseName.PROGRAMACION_WEB, "Horario Tarde", "Curso de Programacion intensivo, 5 semanas", professor2);
            Course course3 = new Course(CourseName.DISEÑO_WEB, "Horario Noche", "Curso de Diseno intensivo, 5 semanas", professor3);
//            Course course4 = new Course(CourseName.COMMUNITY_MANAGER, "Horario Noche", "Curso de Diseno intensivo, 5 semanas");
//            Course course5 = new Course(CourseName.MARKETING, "Horario Tarde", "Curso de Diseno intensivo, 5 semanas");

            courseRepository.save(course1);
            courseRepository.save(course2);
            courseRepository.save(course3);
//            courseRepository.save(course4);
//            courseRepository.save(course5);

            Student student1 = new Student("Federico", "Bon", 28, LocalDate.parse("1992-08-03"), "fedebon@gmail.com", passwordEncoder.encode("123"));
            Student student2 = new Student("Rocio", "Villarreal", 25, LocalDate.parse("1998-08-03"), "ro@gmail.com", passwordEncoder.encode("123"));
            Student student3 = new Student("Lilian", "Caucas", 24, LocalDate.parse("1999-08-03"), "li@gmail.com", passwordEncoder.encode("123"));
            Student student4 = new Student("Sofia", "Lescano", 23, LocalDate.parse("2000-08-03"), "so@gmail.com", passwordEncoder.encode("123"));
            Student student5 = new Student("Emilia", "Tosco", 28, LocalDate.parse("1993-08-03"), "emi@gmail.com", passwordEncoder.encode("123"));
            Student student6 = new Student("Gabriela", "Degiorgi", 33, LocalDate.parse("1990-08-03"), "gabi@gmail.com", passwordEncoder.encode("123"));
            Student student7 = new Student("Yuliana", "Verne", 27, LocalDate.parse("1994-08-03"), "yuli@gmail.com", passwordEncoder.encode("123"));
            Student student8 = new Student("Elias", "Jara", 22, LocalDate.parse("2001-08-03"), "elias@gmail.com", passwordEncoder.encode("123"));
            Student student9 = new Student("Candela", "Garay", 26, LocalDate.parse("1995-08-03"), "cande@gmail.com", passwordEncoder.encode("123"));
            Student student10 = new Student("Agustin", "Carrizo", 34, LocalDate.parse("1989-08-03"), "agus@gmail.com", passwordEncoder.encode("123"));

            studentRepository.save(student1);
            studentRepository.save(student2);
            studentRepository.save(student3);
            studentRepository.save(student4);
            studentRepository.save(student5);
            studentRepository.save(student6);
            studentRepository.save(student7);
            studentRepository.save(student8);
            studentRepository.save(student9);
            studentRepository.save(student10);


            StudentCourse studentCourse = new StudentCourse(student1, course1);
            StudentCourse studentCourse2 = new StudentCourse(student2, course2);
            StudentCourse studentCourse3 = new StudentCourse(student3, course3);
            StudentCourse studentCourse4 = new StudentCourse(student4, course1);
            StudentCourse studentCourse5 = new StudentCourse(student5, course2);
            StudentCourse studentCourse6 = new StudentCourse(student6, course3);
            StudentCourse studentCourse7 = new StudentCourse(student7, course1);
            StudentCourse studentCourse8 = new StudentCourse(student8, course2);
            StudentCourse studentCourse9 = new StudentCourse(student9, course3);
            StudentCourse studentCourse10 = new StudentCourse(student10, course1);

            studentCourseRepository.save(studentCourse);
            studentCourseRepository.save(studentCourse2);
            studentCourseRepository.save(studentCourse3);
            studentCourseRepository.save(studentCourse4);
            studentCourseRepository.save(studentCourse5);
            studentCourseRepository.save(studentCourse6);
            studentCourseRepository.save(studentCourse7);
            studentCourseRepository.save(studentCourse8);
            studentCourseRepository.save(studentCourse9);
            studentCourseRepository.save(studentCourse10);



        };
    }
}






