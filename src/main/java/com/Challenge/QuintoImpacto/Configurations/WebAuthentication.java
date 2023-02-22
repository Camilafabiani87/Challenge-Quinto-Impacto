package com.Challenge.QuintoImpacto.Configurations;

import com.Challenge.QuintoImpacto.Models.Professor;
import com.Challenge.QuintoImpacto.Models.Student;
import com.Challenge.QuintoImpacto.Repositories.ProfessorRepository;
import com.Challenge.QuintoImpacto.Repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.GlobalAuthenticationConfigurerAdapter;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration

public class WebAuthentication extends GlobalAuthenticationConfigurerAdapter {
    @Autowired
    StudentRepository studentRepository;
    @Autowired
    ProfessorRepository professorRepository;

    @Override
    public void init(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(email -> {

            Student student = studentRepository.findByEmail(email);
            Professor professor = professorRepository.findByEmail(email);

            if ( student != null && student.isEnabled() ) {
                if ( student.getEmail().contains("@admin.com") )
                    return new User(student.getEmail(), student.getPassword(), AuthorityUtils.createAuthorityList("ADMIN"));
                else {
                    return new User(student.getEmail(), student.getPassword(), AuthorityUtils.createAuthorityList("Student"));
                }

            } else if ( professor != null ) {
                return new User(professor.getEmail(), professor.getPassword(), AuthorityUtils.createAuthorityList("Professor"));

            } else {
                throw new UsernameNotFoundException("Unknown user: " + email);
            }
        });
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }
}




