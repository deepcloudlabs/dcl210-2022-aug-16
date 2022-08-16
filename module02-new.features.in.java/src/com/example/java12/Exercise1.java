package com.example.java12;

public class Exercise1 {

	public static void main(String[] args) {
		var weekDay = 3;
		var status = switch (weekDay) {
		case 1, 2, 3, 4, 5 -> {
			yield "working";
		}
		case 6, 7 -> {
			yield "resting";
		}
		default -> {
			yield "unknown";
		}
		};
		status = switch (weekDay) {
		case 1:
		case 2:
		case 3:
		case 4:
		case 5:
			yield "working";
		case 6:
		case 7:
			yield "working";
		default:
			yield "unknown";
		};
		System.out.println("status= %s".formatted(status));
	}

}
