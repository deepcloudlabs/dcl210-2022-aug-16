package com.example.java14;

import java.util.Objects;

public class Exercise1 {

	public static void main(String[] args) {
		B b = null;
		if (b instanceof D) { // guard
			D d = (D) b; // type casting is safe
			d.fun();
		}
        if (b instanceof D d && d.x > 30) { // guard + type casting
        	d.fun();
        }
	}

}

class A {
}

class B extends A {
}

class C extends A  implements X {
}

class D extends B implements  Z {
	int x=42;
	void fun() {}

	@Override
	public boolean equals(Object o) {
		return o instanceof D d 
				&& Objects.nonNull(d)
				&& d.x == this.x;
	}
	
}

interface X {}
interface Y {}
interface Z extends X,Y {}