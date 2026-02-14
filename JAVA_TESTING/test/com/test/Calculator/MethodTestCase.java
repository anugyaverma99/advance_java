package com.test.Calculator;

import static org.junit.jupiter.api.Assertions.*;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.Arguments;

class MethodTestCase {

    Calculator calc = new Calculator();

    @ParameterizedTest
    @MethodSource("provideDivisionTestCases")
    void testDivideWithMethodSource(int a, int b, int expected) {
        assertEquals(expected, calc.div(a, b));
    }

    static Stream<Arguments> provideDivisionTestCases() {
        return Stream.of(
            Arguments.of(10, 2, 5),
            Arguments.of(20, 4, 5),
            Arguments.of(-10, 2, -5),
            Arguments.of(0, 5, 0)
        );
    }
}
