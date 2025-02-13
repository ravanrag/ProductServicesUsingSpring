package com.example.simplespring.Inheritance.mappedSuperClass;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "mps_Instructor")
public class Instructor extends User{
    String specilisation;
}
