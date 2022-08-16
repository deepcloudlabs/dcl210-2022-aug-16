package com.example.java7;

public class Exercise4 {

	@SuppressWarnings("finally")
	public static int haveGun() {
		try {
			// throw new IndexOutOfBoundsException();
			return 100;
		} finally { // always runs!
			return 200;
		}
	}

	public static void main(String[] args) {
		System.out.println(haveGun());
	}

}
