package com.example.java7;

public class Exercise02 {

	public static void main(String[] args) {
		String day = "wednesday";
		int weekDay = 0;
		switch (day) { // String
		case "monday":
			weekDay = 1;
			break;
		case "tueday":
			weekDay = 2;
			break;
		case "wednesday":
			weekDay = 3;
			break;
		default:
			throw new IllegalArgumentException("Unexpected day: %s".formatted(day));
		}
		System.out.println(weekDay);
	}

}
