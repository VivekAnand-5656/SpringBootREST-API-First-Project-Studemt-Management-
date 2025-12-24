package com.example.RESTAPILearning.DTO;

import lombok.Data;

@Data
public class StudentDTO {
    private long id;
    private String name;
    private String email;

    public StudentDTO( long id,String name, String email) {
        this.name = name;
        this.id = id;
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
