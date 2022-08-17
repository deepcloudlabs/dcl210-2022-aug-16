package com.example.puzzle;

import java.util.IdentityHashMap;

public class Puzzle62 {
	// -Djava.lang.Integer.IntegerCache.high=4096
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		int x = 42; // 4-byte
		Integer y = 42; // Object Header (12-Byte) + 4-byte = 16-byte 
		IdentityHashMap<Integer, String> map = new IdentityHashMap<Integer, String>();
		System.err.println(map.size());
		map.put(Integer.valueOf(108), "108"); // valueOf : Object Pooling
		System.err.println(map.size());
		map.put(Integer.valueOf(108), "108");
		System.err.println(map.size());
		map.put(Integer.valueOf(549), "549");
		System.err.println(map.size());
		map.put(Integer.valueOf(549), "549");
		System.err.println(map.size());

	}

}
