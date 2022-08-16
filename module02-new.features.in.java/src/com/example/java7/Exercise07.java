package com.example.java7;

import java.util.concurrent.ThreadLocalRandom;

public class Exercise07 {

	public static void haveSun(int x) throws FirstException, SecondException {
		try {
			if (ThreadLocalRandom.current().nextBoolean())
				throw new FirstException();
			else
				throw new SecondException();
		} catch (Exception e) {
			System.out.println("Error has occurred: %s".formatted(e.getMessage()));
			throw e; // re-throw
		}
	}

	public static void main(String[] args) {
		// More Specific Re-throw

	}

}

@SuppressWarnings("serial")
class FirstException extends Exception {
}

@SuppressWarnings("serial")
class SecondException extends Exception {
}

@SuppressWarnings("serial")
class ThirdException extends FirstException {
}
