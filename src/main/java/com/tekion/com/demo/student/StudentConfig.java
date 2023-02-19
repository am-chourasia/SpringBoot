package com.tekion.com.demo.student;

import com.tekion.com.demo.datasource.model.Student;
import com.tekion.com.demo.datasource.repository.StudentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class StudentConfig {
    // Spring Boot will automatically call the run method of all beans implementing this interface after the
    // application context has been loaded.
    @Bean
    CommandLineRunner commandLineRunner(StudentRepository studentRepository) {
        return (args) -> {
            Student maria = new Student(
                    "maria",
                    "maria@email.com",
                    LocalDate.of(2001, Month.AUGUST, 2)
            );
            Student gareema = new Student(
                    "gareema",
                    "gareema@email.com",
                    LocalDate.of(2002, Month.FEBRUARY, 28)
            );
            studentRepository.saveAll(List.of(maria, gareema));
        };
    }
}
