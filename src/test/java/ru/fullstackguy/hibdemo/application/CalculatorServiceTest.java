package ru.fullstackguy.hibdemo.application;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorServiceTest {

    @Autowired
    private CalculatorService calculator;

    @BeforeEach
    void setUp() {
        calculator = new CalculatorService();
    }

    @Test
    void add() {
        // given

        // when
        var result = calculator.add(2, 2);

        // then
        Assertions.assertEquals(4, result);
    }

    @Test
    void addZero() {
        // w
        var result = calculator.add(2, 0);

        // t
        Assertions.assertEquals(2, result);
    }
}