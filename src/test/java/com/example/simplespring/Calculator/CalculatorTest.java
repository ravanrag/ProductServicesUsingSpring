package com.example.simplespring.Calculator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {
    @Test
    void add(){
        Calculator c = new Calculator();
        int result = c.add(10,20);
        Assertions.assertEquals(30,result);

    }

}