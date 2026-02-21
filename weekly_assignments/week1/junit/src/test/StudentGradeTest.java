package test;

import main.StudentGrade;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;


public class StudentGradeTest {
	StudentGrade  grade=new StudentGrade();
	@Test
	public void checkGrade() {
		assertEquals("Distinction",grade.calculateGrade(85));
		assertEquals("First Class",grade.calculateGrade(65));
		assertEquals("Second Class",grade.calculateGrade(55));
		assertEquals("Fail",grade.calculateGrade(40));
		
		
		assertNotNull(grade.calculateGrade(78));
		assertThrows(IllegalArgumentException.class,
        		()-> grade.calculateGrade(-13));
	
		
	}
	@Test
	public void testGradeStatus(){
		assertTrue(grade.isPassed(75));
		assertFalse(grade.isPassed(45));	
	}
	
	

}
