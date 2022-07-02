package com.app.DTO;

import lombok.Data;

import java.time.LocalDate;

@Data
public class StudentNameResponseDto {
    private String name;
    private int age;
    private LocalDate dateOfBirth;
    private String email;
}
