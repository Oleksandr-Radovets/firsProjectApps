package com.app.DTO;

import lombok.Data;

import java.time.LocalDate;

@Data
public class CreateStudentRequestDto {
    private String name;
    private String surname;
    private LocalDate dateOfBirth;
    private String email;

    @Override
    public String toString() {
        return "CreateStudentRequestDto{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", email='" + email + '\'' +
                '}';
    }
}
