package com.app.domain;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;

@Data
@Entity
@Getter
@Setter
public class StudentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private LocalDate dateOfBirth;
    private int age;

    @Override
    public String toString() {
        return "StudentAC{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", mail='" + email + '\'' +
                ", dob=" + dateOfBirth +
                '}';
    }
}
