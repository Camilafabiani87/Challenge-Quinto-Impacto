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
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@SpringBootApplication
public class QuintoImpactoApplication {

	@Autowired
	private PasswordEncoder passwordEncoder;

	public static void main(String[] args) {
		SpringApplication.run(QuintoImpactoApplication.class, args);
	}

	@Bean
	public CommandLineRunner initData(StudentRepository studentRepository, CourseRepository courseRepository, StudentCourseRepository studentCourseRepository, ProfessorRepository professorRepository){
		return args ->{

			Student admin = new Student("Admin","Admin",50,LocalDate.parse("1975-08-03"),"admin@admin.com",passwordEncoder.encode("123"));
			studentRepository.save(admin);

			Professor professor1 = new Professor("Gisela","Ariza","gi@gmail.com",passwordEncoder.encode("123"));
			Professor professor2 = new Professor("Camila","Fabiani","ca@gmail.com",passwordEncoder.encode("123"));
			Professor professor3 = new Professor("Pablo","Ramirez","pablo@gmail.com",passwordEncoder.encode("123"));

			professorRepository.save(professor1);
			professorRepository.save(professor2);
			professorRepository.save(professor3);


			Course course1 = new Course(CourseName.FOTOGRAFIA, "Horario Manana", "Curso de Fotografia intensivo, 5 semanas",professor1);
			Course course2 = new Course(CourseName.PROGRAMACION_WEB, "Horario Tarde", "Curso de Programacion intensivo, 5 semanas",professor2);
			Course course3 = new Course(CourseName.DISEÑO_WEB, "Horario Noche", "Curso de Diseno intensivo, 5 semanas",professor3);
			Course course4 = new Course(CourseName.COMMUNITY_MANAGER, "Horario Noche", "Curso de Diseno intensivo, 5 semanas");
			Course course5 = new Course(CourseName.MARKETING, "Horario Tarde", "Curso de Diseno intensivo, 5 semanas");




			courseRepository.save(course1);
			courseRepository.save(course2);
			courseRepository.save(course3);
			courseRepository.save(course4);
			courseRepository.save(course5);




			Student student1 = new Student("Federico","Bon",20,LocalDate.parse("2003-08-03"),"fedebon@gmail.com",passwordEncoder.encode("123"));
			Student student2 = new Student("Rocio","Villarreal",25,LocalDate.parse("2003-08-03"),"ro@gmail.com",passwordEncoder.encode("123"));
			Student student3 = new Student("Lilian","Caucas",28,LocalDate.parse("2003-08-03"),"li@gmail.com",passwordEncoder.encode("123"));



			studentRepository.save(student1);
			studentRepository.save(student2);
			studentRepository.save(student3);

			StudentCourse studentCourse = new StudentCourse(student1,course1);
			StudentCourse studentCourse2 = new StudentCourse(student2,course2);
			StudentCourse studentCourse3 = new StudentCourse(student3,course3);

			studentCourseRepository.save(studentCourse);
			studentCourseRepository.save(studentCourse2);
			studentCourseRepository.save(studentCourse3);



		};
	}
}






