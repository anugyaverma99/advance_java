public class Calculator {
    public int add(int a, int b) {
		return a+b;
	}
	
    public int subtract(int a, int b) {
        return a-b;
    }
    
    public boolean isEven(int num) {
        return num % 2 == 0;
    }
    
    public int divide(int a, int b) {
        if (b == 0) {
            throw new IllegalArgumentException("Divisor cannot be zero.");
        }else if(b<0) {
        	throw new IllegalArgumentException("Divisor cannot be negative.");
        }
        return a / b;
    }
    
    public int multiply(int a, int b) {
    	return a * b;
    }
}
