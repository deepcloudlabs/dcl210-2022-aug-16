package com.example.java11;

import java.util.function.Predicate;

@SuppressWarnings("unused")
public class Exercise1 {
	public static void main(String[] args) {
		Predicate<Integer> isOdd = u -> u % 2 == 1;
		Predicate<Integer> isEven1 = (@NotNull var u) -> u % 2 == 0;
		var isEven2 = isEven1.negate();

	}
}

@interface NotNull {
}