package test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.function.BooleanSupplier;

import org.junit.jupiter.api.Test;

import main.LoanService;



public class LoanServiceTest {
	LoanService s=new LoanService();
	
	@Test
	public void testValidEligibilty() {
		assertTrue(s.isEligible(25,210000));
		
		
	}
	@Test
	public void testInvalidAge() {
		assertFalse(s.isEligible(15,54000));
	}
	@Test
	public void testInvalidSalary() {
		assertFalse(s.isEligible(34, 2345));
	}
	@Test
	public void validEMIcalculation() {
		assertEquals(1000,s.calculateEMI(24000,2));
	}
	@Test
	public void invalidLoanAmount() {
		assertThrows(IllegalArgumentException.class,
        		()-> s.calculateEMI(-13, 245000));
	}
	@Test
	public void invalidTenure() {
		assertThrows(IllegalArgumentException.class,
        		()-> s.calculateEMI(123456, -76));
	}
	@Test
	public void allCreditCategories() {
		assertAll(
		()->assertEquals("Premium",s.getLoanCategory(780)),
		()->assertEquals("Standard",s.getLoanCategory(650)),
		()->assertEquals("High Risk",s.getLoanCategory(123))
		);
	}
	@Test
	public void checkBoundaryValues() {
		assertNotNull(s.getLoanCategory(345));
		
	}
	@Test
	public void checkBoundary2Values() {
		
		assertTrue(s.isEligible(24, 234567));
	}

	@Test
	public void checkMultipleAssertions() {
		assertAll(
				()->assertEquals("Premium",s.getLoanCategory(780)),
				()->assertTrue(s.isEligible(25,270000)),
				()->assertFalse(s.isEligible(31, 23452))
				
				);
	}
	
	

}
