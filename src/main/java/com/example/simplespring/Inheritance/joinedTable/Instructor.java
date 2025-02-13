package com.example.simplespring.Inheritance.joinedTable;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "jt_Instructor")
public class Instructor extends User {
    String specilisation;
}
