package com.example.simplespring.Inheritance.mappedSuperClass;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name="mps_mentor")
public class Mentor  extends User{
    String company;
    int averageRating;
}
