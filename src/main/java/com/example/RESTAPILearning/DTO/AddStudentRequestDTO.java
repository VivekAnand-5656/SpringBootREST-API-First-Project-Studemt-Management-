package com.example.RESTAPILearning.DTO;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class AddStudentRequestDTO {

    @NotBlank(message = "Name Required")
    private String name;
    @Email
    @NotBlank(message = "Email is Required")
    private String email;
}
