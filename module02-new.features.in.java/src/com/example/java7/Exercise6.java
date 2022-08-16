package com.example.java7;

public class Exercise6 {

	public static void haveGun() {
		// try-with-resources
		try(
				MyResource myRes1 = new MyResource(1);
				MyResource myRes2 = new MyResource(2);
				) {
			throw new IndexOutOfBoundsException("Ooopss!");
		} 
		// implicit finally
		catch (Exception e) {
			System.out.println("Error has occured in the application: %s".formatted(e.getMessage()));
			for (Throwable suppressedException :e.getSuppressed())
			    System.err.println("An error has occured while closing the resource: %s.".formatted(suppressedException.getMessage()));
		} 
	}

	public static void main(String[] args) {
		haveGun();
	}

}
