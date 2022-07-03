package com.app.domain;


import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import javax.persistence.*;
import java.util.Objects;

@Getter
@Setter
@Entity
public class AnimalEntity {


     @javax.persistence.Id
     @GeneratedValue (strategy = GenerationType.AUTO)
     private Integer Id;
     private String name;
     private String animal;
     private int age;

    @Override
    public String toString() {
        return "AnimalEntity{" +
                "Id=" + Id +
                ", name='" + name + '\'' +
                ", animal='" + animal + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AnimalEntity that = (AnimalEntity) o;
        return age == that.age && Objects.equals(Id, that.Id) && Objects.equals(name, that.name) && Objects.equals(animal, that.animal);
    }
    @Override
    public int hashCode() {
        return Objects.hash(Id, name, animal, age);
    }
}
