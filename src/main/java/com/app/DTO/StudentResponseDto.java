package com.app.DTO;


import lombok.Data;
import lombok.ToString;


@Data
@ToString
public class StudentResponseDto {
    private String name;
    private String  surname;
    private String email;
    private int age;
}