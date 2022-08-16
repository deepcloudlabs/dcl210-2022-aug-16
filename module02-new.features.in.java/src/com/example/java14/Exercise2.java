package com.example.java14;

public class Exercise2 {
	public static void main(String[] args) {
		var jack = new Customer("11111111110", "jack shephard", "jack@example.com", "+15555555");
		System.out.println(jack.toString());
		System.out.println(jack.email());
	}
}

// immutable class -> value object
record Customer(String identity, String fullname, String email, String phone) {
}

// Error! Since record class is a final class!
// class GoldCustomer extends Customer {}