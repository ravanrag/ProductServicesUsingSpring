package com.example.simplespring.Inheritance.SingleTable;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "St_Instructor")
@DiscriminatorValue(value = "2")
public class Instructor extends User {
    String specilisation;
}
