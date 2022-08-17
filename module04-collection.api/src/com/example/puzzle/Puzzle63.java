package com.example.puzzle;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Puzzle63 {

	public static void main(String[] args) {
		MoreNumbers moreNumbers = new MoreNumbers();
		System.err.println(moreNumbers.getSize());

	}

	public static void fun(Collection<Integer> numbers) {
		
	}
	public static List<Integer> gun() {
		return Collections.emptyList(); // Null Object Pattern
	}
}

class MoreNumbers {
	private Map<Integer, String> m = new HashMap<Integer, String>();

	public /* void */ MoreNumbers() {
		m.put(108, "108");
		m.putIfAbsent(108, "108");
		m.put(108, "108");
		m.put(549, "549");
		m.put(549, "549");
	}

	public int getSize() {
		return m.size();
	}
}