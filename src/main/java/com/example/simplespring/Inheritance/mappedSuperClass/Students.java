package com.example.simplespring.Inheritance.mappedSuperClass;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name="mps_student")
public class Students  extends User{
    String course;
    String batch;
}
