package com.example.RESTAPILearning.repositiry;

import com.example.RESTAPILearning.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StudentRepositiry extends JpaRepository<Student, Long> {
    Optional<Student> findByName(String name);
}
