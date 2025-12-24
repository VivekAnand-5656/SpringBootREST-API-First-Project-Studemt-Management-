package com.example.RESTAPILearning.controller;

import com.example.RESTAPILearning.DTO.StudentDTO;
import com.example.RESTAPILearning.DTO.TeacherDTO;
import com.example.RESTAPILearning.entity.Student;
import com.example.RESTAPILearning.repositiry.StudentRepositiry;
import com.example.RESTAPILearning.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class StudentController {
    private final StudentService studentService;


    @GetMapping("/student")
    public List<StudentDTO> getStudent(){
        return studentService.getAllStudents();
    }
    @GetMapping("/student/{id}/{name}")
    public String getStudentById(@PathVariable Long id,@PathVariable String name){
        return "Path variable = ID : "+id+", : Name : "+name;
    }


}
