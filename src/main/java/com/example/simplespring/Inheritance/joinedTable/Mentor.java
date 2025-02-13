package com.example.simplespring.Inheritance.joinedTable;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name="jt_mentor")
public class Mentor  extends User {
    String company;
    int averageRating;
}
