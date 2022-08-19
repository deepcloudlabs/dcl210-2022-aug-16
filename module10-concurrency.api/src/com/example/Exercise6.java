package com.example;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public class Exercise6 {
	public static void main(String[] args) {
		var task = new AtomicTask();
		var threads = new ArrayList<Thread>();
		for (var i=0;i<4;++i) {
			threads.add(new Thread(task));
		}
		threads.forEach(Thread::start);
		threads.forEach( thread -> {
			try { thread.join(); } catch (InterruptedException e) {}
		});
		System.out.println(task.getCounter());
	}
}

class Task implements Runnable {
	private int counter; // instance variable -> Heap 

	public int getCounter() {
		return counter;
	}

	@Override
	public void run() {
		for (var i = 0; i < 200_000; ++i)
			synchronized (this) {
				counter++;				
			}
	}

}

// Lock-free Solution -> AtomicInteger
class AtomicTask implements Runnable {
	private AtomicInteger counter = new AtomicInteger(0); // instance variable -> Heap 
	
	public int getCounter() {
		return counter.get();
	}
	
	@Override
	public void run() {
		Thread.onSpinWait();
		for (var i = 0; i < 200_000; ++i)
			counter.incrementAndGet();				
	}
	
}
