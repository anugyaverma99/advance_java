package com.test.Calculator;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

public class CSVFileTestCase {
	Calculator c=new Calculator();
	@ParameterizedTest
	@CsvFileSource(files="test-data/add.csv",numLinesToSkip=1)
	public void simpleAddTest(int a,int b,int expected) {
		System.out.println("Simple @CsvFileSource test: "+a+" + "+b+" = "+(a+b));
		assertEquals(expected,c.add(a,b));
		}

}
