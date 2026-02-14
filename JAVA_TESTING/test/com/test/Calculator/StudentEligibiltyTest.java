package com.test.Calculator;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertAll;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.provider.CsvSource;

import org.junit.jupiter.params.ParameterizedTest;



public class StudentEligibiltyTest {
	StudentEligibilty se=new StudentEligibilty();
	StudentEligibilty se1=se;
	StudentEligibilty se2=new StudentEligibilty();
	
	@Test
	void studentEligibilty() {
		assertTrue(se.isEligible(19));
	}
	@Test
	void studentNotEligible() {
		assertFalse(se.isEligible(17));
	}
	@Test
	void studentEqual() {
		assertEquals(true,se.isEligible(18));
	}
	@Test
	void studentNotEqual() {
		assertNotEquals(false,se.isEligible(21));
	}
	@Test
	void objectNotNull() {
		assertNotNull(se);
	}
	@Test
	void studentSame() {
		
		assertSame(se1,se);		
	}
	@Test 
	void studentNotSame(){
		
		assertNotSame(se2,se);
	}
	@Test
	void studentAll() {
		assertAll(
		()->assertSame(se,se1),
		()->assertNotSame(se,se2)
	);
	}
	@Test
	void handleException() {
		assertThrows(IllegalArgumentException.class,()->{
			se.isEligible(150);
		});
	}
	@ParameterizedTest
	@CsvSource({
		"2,3,5",
		"0,0,0",
		"-5,10,5",
		"100,200,300"
	})
	public void testAddParameterized(int a, int b,int expected) {
		assertEquals(expected,a,b);
	}
	
	
	

}
