package com.example.java7;

public class Exercise03 {

	public static void haveFun() {
	    // instead of writing the following
		try {
			
		}catch (IndexOutOfBoundsException e) {
			System.out.println("Error has occurred: %s".formatted(e.getMessage()));
		}catch (IllegalArgumentException e) {
			System.out.println("Error has occurred: %s".formatted(e.getMessage()));			
		}
		//we prefer to use the following multi-catch
		try {
			
		}catch (IndexOutOfBoundsException | IllegalArgumentException e) {
			System.out.println("Error has occurred: %s".formatted(e.getMessage()));			
		}
	}
	
	public static void main(String[] args) {
		

	}

}
