package com.example;

import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.IntStream;

public class Exercise08 {

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		// IntStream, LongStream, DoubleStream 
		var numbers = 
		IntStream.rangeClosed(1, 10_000)
		         .boxed()
		         .toList();
		var randomNumbers =
        ThreadLocalRandom.current()
                         .ints(1, 60)
                         .distinct()
                         .sorted()
                         .boxed()
                         .toList();
		System.out.println(randomNumbers);
	}

}
