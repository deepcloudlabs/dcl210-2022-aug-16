package com.example.order.application;

public class A {
	private int x = 42;

	public A(int x) {
		this.x = x;
	}

	public int getX() {
		return x;
	}

	@Override
	public String toString() {
		return "A [x=" + x + "]";
	}

}
