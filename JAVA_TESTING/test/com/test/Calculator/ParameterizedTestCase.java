package com.test.Calculator;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.params.ParameterizedTest;

import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

public class ParameterizedTestCase{
	ParameterizedCase p=new ParameterizedCase();
	@ParameterizedTest
	@CsvSource({
		"2,3,5",
		"0,0,0",
		"-5,10,5",
		"100,200,300"
	})
	public void testAddParameterized(int a, int b,int expected) {
		assertEquals(expected,p.add(a,b));
	}
	@ParameterizedTest
	@ValueSource(ints= {2,4,8,16,-18})
	public void testIsEvenNumber(int number) {
		assertTrue(p.isEven(number));
	}
	@ValueSource(ints= {1,3,5,7,-19})
	public void testIsNotEvenNumber(int number) {
		assertTrue(p.isNotEven(number));
	}
	


}
