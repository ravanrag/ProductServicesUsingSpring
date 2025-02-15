package com.example.simplespring.Inheritance.SingleTable;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name="St_mentor")
@DiscriminatorValue(value = "3")
public class Mentor  extends User {
    String company;
    int averageRating;
}
