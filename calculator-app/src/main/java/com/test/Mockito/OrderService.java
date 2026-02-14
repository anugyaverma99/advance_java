package com.test.Mockito;


public class OrderService {
	private PaymentService paymentService;
	
	// Constructor Injection
	public OrderService(PaymentService paymentService) {
		this.paymentService=paymentService;
	}
	
	// Method to Test
	public String placeOrder(double amount) {
		System.out.println("[Order Service] Placing order...");
		
		boolean paymentSuccess = paymentService.processPayment(amount);
		
		if(paymentSuccess) {
			return "ORDER PLACED";
		}
		return "PAYMENT FAILED";
	}
	
	// Additional method for verification
	public boolean validateAndPlaceOrder(double amount) {
		if(amount <= 0) {
			return false;
		}
		
		boolean paymentSuccess = paymentService.processPayment(amount);
		return paymentSuccess;
	}
}