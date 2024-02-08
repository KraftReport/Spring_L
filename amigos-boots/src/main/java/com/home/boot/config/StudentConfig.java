package com.home.boot.config;

import com.home.boot.model.Student;
import com.home.boot.repository.StudentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.List;

@Configuration
public class StudentConfig {
    @Bean
    CommandLineRunner cmdRunner(StudentRepository studentRepository){
        return args -> {
            var myosetpaing = new Student(1l,"Myo Set Paing","kraftreport04@gmail.com", LocalDate.of(2002,12,26));
            studentRepository.saveAll(List.of(myosetpaing));
        };
    }
}
