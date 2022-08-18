package com.example.dto;

public class CalculatorRequest {
	private double x;
	private double y;
	private Operation operation;

	public CalculatorRequest() {
	}

	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}

	public Operation getOperation() {
		return operation;
	}

	public void setOperation(Operation operation) {
		this.operation = operation;
	}

	@Override
	public String toString() {
		return "CalculatorRequest [x=" + x + ", y=" + y + ", operation=" + operation + "]";
	}

}
