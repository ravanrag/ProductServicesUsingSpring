package com.example.simplespring.Inheritance.SingleTable;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name="St_student")
@DiscriminatorValue(value = "1")
public class Students  extends User {
    String course;
    String batch;
}
