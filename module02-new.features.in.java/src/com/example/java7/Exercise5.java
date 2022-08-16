package com.example.java7;

public class Exercise5 {

	public static int haveGun() {
		MyResource myRes1 = new MyResource(1);
		MyResource myRes2 = new MyResource(2);
		try {
			throw new IndexOutOfBoundsException();
		} finally { // always runs!
			try {
				myRes1.close();
			} catch (Exception e) {
				System.err.println("An error has occured while closing the resource (%d): %s.".formatted(myRes1.getId(),e.getMessage()));
			} finally {
				try {
					myRes2.close();
				} catch (Exception e) {
					System.err.println("An error has occured while closing the resource (%d): %s.".formatted(myRes2.getId(),e.getMessage()));
				} 				
			}
		}
	}

	public static void main(String[] args) {
		System.out.println(haveGun());
	}

}

class MyResource implements AutoCloseable {
	private final int resourceId;
	
	public MyResource(int resourceId) {
		this.resourceId = resourceId;
	}

	public int getId() {
		return resourceId;
	}

	@Override
	public void close() throws Exception {
		System.out.println("Closing the resource (%d)".formatted(resourceId));
		throw new RuntimeException("Something is wrong!");
	}
	
}
