package com.example.java16;

import jdk.incubator.vector.IntVector;

public class Exercise1 {

	public static void main(String[] args) {
		// Vector API
		int[] vec1 = { 1, 3, 5, 7 };
		int[] vec2 = { 2, 4, 6, 8 };
		int[] vec3 = new int[4];
		// vec3 = vec1 * vec2
		for (var i = 0; i < vec1.length; ++i) {
			vec3[i] = vec1[i] * vec2[i];
		}
		var vector1 = IntVector.fromArray(IntVector.SPECIES_128,vec1,0);
		var vector2 = IntVector.fromArray(IntVector.SPECIES_128,vec2,0);
		var vector3 = vector1.mul(vector2);
		vector3.intoArray(vec3, 0);
	}

}
