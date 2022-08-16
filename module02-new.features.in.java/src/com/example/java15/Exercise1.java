package com.example.java15;

public class Exercise1 {

	public static void main(String[] args) {
		// sealed, non-sealed, "final", permits all controls "extensibility"

	}

}

abstract sealed class Person permits Employee, Manager {}

sealed abstract class Employee extends Person permits Engineer, Secretary {}
final class Manager extends Person {}
non-sealed abstract class Engineer extends Employee {}
final class Secretary extends Employee {}
class SoftwareEngineer extends Engineer {}