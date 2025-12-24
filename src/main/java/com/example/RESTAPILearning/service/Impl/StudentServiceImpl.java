package com.example.RESTAPILearning.service.Impl;

import com.example.RESTAPILearning.DTO.StudentDTO;
import com.example.RESTAPILearning.entity.Student;
import com.example.RESTAPILearning.repositiry.StudentRepositiry;
import com.example.RESTAPILearning.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {
    private final StudentRepositiry studentRepositiry;
    @Override
    public List<StudentDTO> getAllStudents() {
        List<Student> students = studentRepositiry.findAll();
        return students.stream().map(student -> new StudentDTO(student.getId(),student.getName(),student.getEmail())).toList();

    }
}
