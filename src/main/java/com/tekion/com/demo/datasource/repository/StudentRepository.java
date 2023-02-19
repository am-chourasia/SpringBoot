package com.tekion.com.demo.datasource.repository;

import com.tekion.com.demo.datasource.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
//    @Query("select S from Student S where S.email = ?1")
    Optional<Student> findStudentByEmail(String email);
}
