package com.example.simplespring.Inheritance.TablePerClass;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name="tpc_student")
@DiscriminatorValue(value = "1")
public class Students  extends User {
    String course;
    String batch;
}
