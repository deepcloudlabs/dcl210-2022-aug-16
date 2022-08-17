package com.example.summary;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;
import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.ConcurrentSkipListSet;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.LinkedBlockingDeque;

public class Exercise01 {

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		// Legacy Collection -> Thread Safe
		Vector<Integer> vector = new Vector<>();
		vector.add(42);
		vector.add(4);
		vector.add(8);
		Stack<Integer> stack = new Stack<>(); // Deque
		stack.push(42);
		
		// Collection API (1.2) -> data store/access/manipulation -> memory organization
        //                   access: iterator pattern
		// Linear     : Set, List, Deque -> stores only values
		// Associative: Map -> Entry (key -> value), There is NO multi-map
		// Set: unordered -> unsorted, unique
		// List: ordered, duplicate, can grow in one direction
		// Deque: ordered, duplicate, can grow in either direction
		//        stack, queue
		
		
		// NOT Thread Safety
		// ArrayList, LinkedList, HashSet, EnumSet, LinkedHashSet, TreeSet, 
		//   HashMap, LinkedHashMap, ArrayDeque, ...
		var numbers = new ArrayList<Integer>();
		// thread #1: for (var number: numbers) {}
        // thread #2: numbers.add(42); or numbers.remove(10); or numbers.clear() ...
		// ConcurrentModificationException!!! -> Fail fast!
		
		// Thread Safe
		// 1. Thread Unsafe --> Collections.synchronizedList/synchronizedSet/synchronizedMap
		var list = new ArrayList<>();
		var threadSafeList = Collections.synchronizedList(list);
		// 2. ConcurrentXYZ, BlockingXYZ
		ConcurrentLinkedDeque<Integer> list2; // high throughput wrt # of cores
		LinkedBlockingDeque<Integer> list3;
		ConcurrentHashMap<String, Integer> map1; // multi-core > 10
		ConcurrentSkipListSet<Integer> set1;
		// 3. Read Heavy -> CopyOnWrite
		CopyOnWriteArrayList<Integer> list4;
		// 4. Immutable Collection when there is no mutators!
		List.of(1,2,3).clear(); // UnsupportedOperationException -> bug
		
		// Implementation
		// 1. List -> ArrayList, LinkedList
		//            new ArrayList<>(50_000_000);
		// 2. Set -> HashSet (chaotic), LinkedHashSet (insertion order), TreeSet (Comparator/Comparable), EnumSet
		// 3. Map -> HashMap, LinkedHashMap, TreeMap, IdentityHashMap, EnumMap
		
	}

}
