package com.tekion.com.demo.student;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Service
public class StudentService {
    public List<Student> getStudents() {
        return List.of(
                new Student(10L, "Ashish", "email", LocalDate.of(2001, Month.JANUARY, 2), 21),
                new Student(12L, "Kiran", "kiran@email.com", LocalDate.of(2001, Month.JANUARY, 2), 21)
        );
    }
}
