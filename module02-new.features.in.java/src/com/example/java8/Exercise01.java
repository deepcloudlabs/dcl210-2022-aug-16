package com.example.java8;

import java.util.Comparator;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.function.ToDoubleFunction;
import java.util.stream.Collectors;

public class Exercise01 {

	public static void main(String[] args) {
		// New Paradigm: Functional Programming
		List<Student> students = List.of(
		    new Student("jack", 2001, List.of(3.0,3.2,3.8,2.7), Department.AI_ENGINEEERING, "MIT"),
		    new Student("kate", 2000, List.of(3.1,4.0,3.2,4.0), Department.SOFTWARE_ENGINEERING, "MIT"),
		    new Student("james", 2002, List.of(3.0,3.1,3.7,2.8), Department.AI_ENGINEEERING, "MIT"),
		    new Student("ben", 2003, List.of(2.8,3.3,3.3,2.7), Department.SOFTWARE_ENGINEERING, "MIT")
	    );
		Student highestGradeStudent = null;
		double highestGrade = 0.0;
		for (Student student : students) {
			DoubleSummaryStatistics stats = new DoubleSummaryStatistics();
			for (double grade : student.grades())
				stats.accept(grade);
			double averageGrade = stats.getAverage();
			if (Objects.isNull(highestGradeStudent)) {
				highestGradeStudent = student;
				highestGrade = averageGrade;
			}
			else if (highestGrade < averageGrade ){
				highestGradeStudent = student;					
				highestGrade = averageGrade;
			}
		}
		System.out.println(highestGradeStudent);
		// Functional Interface -> SAM
		ToDoubleFunction<Student> averageGrade = 
				ogrenci -> ogrenci.grades().stream()
				                  .collect(Collectors.summarizingDouble(Double::doubleValue))
				                  .getAverage();
		students.stream()
		        .parallel()
		        .max(Comparator.comparingDouble(averageGrade)) 
		        .ifPresent(System.out::println);
		// New Language Features
		// 1. Interface related new features
		//    a) Functional Interface -> @FunctionalInterface
		//    b) static method -> fp utility method
		//    c) default method -> FP -> Stream API (Java SE 8) -> Collection API
		// 2. Lambda Expression
		// 3. Method Reference
        
	}

}

record Student(String fullname,int birthYear,List<Double> grades,Department department,String university) {}

enum Department {
	AI_ENGINEEERING, COMPUTER_ENGINEERING, COMPUTER_SCIENCE, SOFTWARE_ENGINEERING
}