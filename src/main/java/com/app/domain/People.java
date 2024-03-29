package com.app.domain;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Entity
@Getter
@Setter
public class People {

    @Id
    @GeneratedValue (strategy = GenerationType.TABLE)
    private Integer Id;
    private String name;
    private String lastName;
    private int age;
    private String phone;

    @Override
    public String toString() {
        return "People{" +
                "Id=" + Id +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", aeg=" + age  +
                ", phone='" + phone + '\'' +
                '}';
    }
}
