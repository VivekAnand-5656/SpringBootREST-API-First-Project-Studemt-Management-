package com.example.RESTAPILearning.service;

import com.example.RESTAPILearning.DTO.StudentDTO;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.List;

public interface StudentService {
    List<StudentDTO> getAllStudents();
}
