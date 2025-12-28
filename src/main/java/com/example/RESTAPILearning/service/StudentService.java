package com.example.RESTAPILearning.service;

import com.example.RESTAPILearning.DTO.AddStudentRequestDTO;
import com.example.RESTAPILearning.DTO.StudentDTO;
import org.jspecify.annotations.Nullable;

import java.util.List;
import java.util.Map;

public interface StudentService {
    List<StudentDTO> getAllStudents();
    StudentDTO getStudentById(Long id);
    StudentDTO getStudentByName(String name);

    @Nullable StudentDTO createNewStudent(AddStudentRequestDTO addStudentRequestDTO);

    void deleteStudentById(Long id);

     StudentDTO updateStudent(Long id, AddStudentRequestDTO addStudentRequestDTO);

     StudentDTO updatePartialStudent(Long id, Map<String, Object> updates);
}
