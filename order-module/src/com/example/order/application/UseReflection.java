package com.example.order.application;

public class UseReflection {

	public static void main(String[] args) throws Exception {
		A a = new A(108);
		System.out.println(a.getX());
		var xField = a.getClass().getDeclaredField("x");
		xField.setAccessible(true);
		xField.set(a, 549);
		xField.setAccessible(false);
		System.out.println(a.getX());		
	}

}
