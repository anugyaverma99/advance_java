package com.test.Calculator;

public class StudentEligibilty {
	public boolean isEligible(int age) {
		if(age<0 || age>100) {
			throw new IllegalArgumentException("AGE INVALID");
		}
		if(age>=18) {
			return true;
		}
		return false;
	}
	
}

