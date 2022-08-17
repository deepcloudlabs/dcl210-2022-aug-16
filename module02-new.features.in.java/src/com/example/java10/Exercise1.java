package com.example.java10;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("unused")
public class Exercise1 {
    // Error: var z = 42; // since z is an instance variable
	/**
	 * Error: you cannot use var in method parameters!
	public static int fun(int u) {
		return 2 * u;
	}
	 * @throws IOException 
	*/
	public static void main(String[] args) throws IOException {
		var x = 42; // local variable
        var list = new ArrayList<String>();
        // insteadof Stream<String> stream = list.stream();
        var stream = list.stream();
        var tmpFile = Paths.get("c:", "tmp", "csvfiles", "stocks.csv");
        var bytes = Files.readAllBytes(tmpFile);
        
        var numbers = List.of(1,2,3,4,5,6,7,8,9,10);
        var sum = 0;
        for (var number : numbers) {
        	sum = sum + number;
        }
        for (var i=0;i<10;++i)
        	System.out.println(i);
	}

}
