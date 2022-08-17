package com.example;

import java.util.function.Predicate;
import java.util.stream.Stream;

public class Exercise09 {

	public static void main(String[] args) {
		var countryNames = Stream.of("India", "Turkey", "England", "Germany", "", "", "");
		Predicate<String> isBlank = String::isBlank;
		var isNotBlank = isBlank.negate();
		countryNames.takeWhile(isNotBlank)
		            .forEach(System.out::println);
		System.out.println();
		countryNames = Stream.of("", "", "", "England", "Germany");
		countryNames.dropWhile(isBlank)
		            .forEach(System.out::println);
		
		
	}

}
