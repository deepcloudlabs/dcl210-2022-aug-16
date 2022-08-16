package com.example.java7;

public class Exercise01 {

	public static void main(String[] args) {
		int x = 12; // decimal
		System.out.println("x=%d".formatted(x));
		int y = 012; // octal
		System.out.println("y=%d".formatted(y));
		int z = 0x12; // hex
		System.out.println("z=%d".formatted(z));
		// New in Java 7
		int t = 0b1100_1010; // binary
		System.out.println("t=%d".formatted(t));
		double money = 1_000_000_000.123_456;
		System.out.println("money=%16.9f".formatted(money));
	}

}
