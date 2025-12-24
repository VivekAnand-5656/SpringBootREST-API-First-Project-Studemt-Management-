package com.example.RESTAPILearning.DTO;

import lombok.Data;

@Data
public class TeacherDTO {
    private long id;
    private String name;
    private String email;

    public TeacherDTO(long id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

}
