package com.tekion.com.demo.service;

import com.tekion.com.demo.datasource.model.Student;
import com.tekion.com.demo.datasource.repository.StudentRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getStudents() {
        return studentRepository.findAll();
    }

    public void addNewStudent(Student student) {
        Optional<Student> studentOptional = studentRepository.findStudentByEmail(student.getEmail());
        if (studentOptional.isPresent()) {
            throw new IllegalStateException("Email Taken");
        }
        studentRepository.save(student);
    }

    public void deleteStudent(long id) {
        boolean exists = studentRepository.existsById(id);
        if (exists) {
            studentRepository.deleteById(id);
        }
    }

    @Transactional
    public void updateStudent(Long id, String name, String email) {
        Optional<Student> studentOptional = studentRepository.findById(id);
        if (studentOptional.isPresent()) {
            Student student = studentOptional.get();
            if (name != null && name.length() > 0 && !Objects.equals(student.getName(), name)) {
                student.setName(name);
            }
            if (email != null && email.length() > 0 && !Objects.equals(student.getEmail(), email)) {
                student.setEmail(email);
            }
        }
    }
}
