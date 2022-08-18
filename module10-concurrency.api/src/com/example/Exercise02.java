package com.example;

import java.util.concurrent.Executors;
import java.util.stream.IntStream;

public class Exercise02 {

	public static void main(String[] args) {
//		var threadPool = Executors.newFixedThreadPool(10 * Runtime.getRuntime().availableProcessors());
		var threadPool = Executors.newScheduledThreadPool(10);
		IntStream.range(0, 1_000)
		         .forEach( i -> threadPool.submit(() -> System.out.println("Hello World [%d]!".formatted(i))));
		threadPool.shutdown();
		/*
Hello World [7]!
Hello World [5]!
Hello World [1]!
Hello World [2]!
Hello World [4]!
Hello World [8]!
Hello World [10]!
		 */
	}

}
