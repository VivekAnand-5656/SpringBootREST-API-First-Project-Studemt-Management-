package com.example.RESTAPILearning.controller;

import com.example.RESTAPILearning.DTO.AddStudentRequestDTO;
import com.example.RESTAPILearning.DTO.StudentDTO;
import com.example.RESTAPILearning.service.StudentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Objects;

@RestController
@RequiredArgsConstructor
@RequestMapping("/students")
public class StudentController {
    private final StudentService studentService;


    @GetMapping
    public ResponseEntity<List<StudentDTO>> getStudent(){
//        return studentService.getAllStudents();
        return  ResponseEntity.ok(studentService.getAllStudents());

    }
    @GetMapping("/id/{id}")
    public ResponseEntity<StudentDTO> getStudentById(@PathVariable Long id){
//        return studentService.getStudentById(id);
        return ResponseEntity.ok(studentService.getStudentById(id));
    }
    @GetMapping("/name/{name}")
    public ResponseEntity<StudentDTO> getStudentByName(@PathVariable String name){
        return ResponseEntity.ok(studentService.getStudentByName(name));
    }
    @PostMapping("")
    public ResponseEntity<StudentDTO> createNewStudent(@RequestBody @Valid AddStudentRequestDTO addStudentRequestDTO){
        return ResponseEntity.status(HttpStatus.CREATED).body(studentService.createNewStudent(addStudentRequestDTO));

    }
//    ---- Delete ---
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStudent(@PathVariable Long id){
        studentService.deleteStudentById(id);
        return ResponseEntity.noContent().build();
    }
//    ---- Put ----
    @PutMapping("/{id}")
    public ResponseEntity<StudentDTO> updateStudent(@PathVariable Long id,@RequestBody AddStudentRequestDTO addStudentRequestDTO){
        return ResponseEntity.ok(studentService.updateStudent(id,addStudentRequestDTO));
    }
//    ----- Patch ----
    @PatchMapping("/{id}")
    public ResponseEntity<StudentDTO> updatePartialStudent(@PathVariable Long id,
                                                           @RequestBody Map<String, Object> updates){
        return ResponseEntity.ok(studentService.updatePartialStudent(id,updates));
    }



}
