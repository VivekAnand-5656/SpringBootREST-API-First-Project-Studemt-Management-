package com.example.RESTAPILearning.service.Impl;

import com.example.RESTAPILearning.DTO.AddStudentRequestDTO;
import com.example.RESTAPILearning.DTO.StudentDTO;
import com.example.RESTAPILearning.entity.Student;
import com.example.RESTAPILearning.repositiry.StudentRepositiry;
import com.example.RESTAPILearning.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.jspecify.annotations.Nullable;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {
    private final StudentRepositiry studentRepositiry;
    private final ModelMapper modelMapper;

    @Override
    public List<StudentDTO> getAllStudents() {
        List<Student> students = studentRepositiry.findAll();
        return students
                .stream()
                .map(student -> new StudentDTO(student.getId(), student.getName(), student.getEmail()))
                .toList();
//        return students.stream().map(student -> new StudentDTO(student.getId(),student.getName(),student.getEmail())).toList();

    }
    @Override
    public StudentDTO getStudentById (Long id){
     Student student = studentRepositiry.findById(id).orElseThrow(()->new IllegalArgumentException("Student not found"));
    StudentDTO studentDTO = modelMapper.map(student,StudentDTO.class);
    return studentDTO;
    }

    @Override
    public StudentDTO getStudentByName(String name) {
         Student student = studentRepositiry.findByName(name).orElseThrow(()->new IllegalArgumentException("Student not found of this name"));
         return modelMapper.map(student,StudentDTO.class);
    }

    @Override
    public StudentDTO createNewStudent(AddStudentRequestDTO addStudentRequestDTO) {
        Student newStudent = modelMapper.map(addStudentRequestDTO,Student.class);
        Student student  = studentRepositiry.save(newStudent);
        return modelMapper.map(student,StudentDTO.class);
    }



    @Override
    public void deleteStudentById(Long id) {
        if(!studentRepositiry.existsById(id)){
            throw new IllegalArgumentException("Student does not exists by id."+id);
        } else {
            studentRepositiry.deleteById(id);
        }
    }

    @Override
    public  StudentDTO updateStudent(Long id, AddStudentRequestDTO addStudentRequestDTO) {
        Student student = studentRepositiry.findById(id)
                .orElseThrow(()-> new IllegalArgumentException("Student not found with id : "+id));
        modelMapper.map(addStudentRequestDTO,student);
        student = studentRepositiry.save(student);
        return modelMapper.map(student,StudentDTO.class);
    }

    @Override
    public StudentDTO updatePartialStudent(Long id, Map<String, Object> updates) {
        Student student = studentRepositiry.findById(id)
                .orElseThrow(()-> new IllegalArgumentException("Student not found with id : "+id));
        updates.forEach((field, value)->{
            switch (field){
                case "name":
                    student.setName((String) value);
                    break;
                case "email":
                    student.setEmail((String) value);
                    break;
                default:throw new IllegalArgumentException("Field is not supported");
            }
        });
        Student savestudent = studentRepositiry.save(student);
        return modelMapper.map(savestudent,StudentDTO.class);

    }
}
