package com.test.Mockito;

public class PaymentService {

	public boolean processPayment(double amount) {
		System.out.println("Processing payement of $" + amount);
		return true;
	}
	
	public String getTransactionId(double amount) {
		return "TXN" + System.currentTimeMillis();
	}
}