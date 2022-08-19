package com.example.security;

import java.math.BigInteger;
import java.security.MessageDigest;

public class StudyMessageDigest {

	public static void main(String[] args) throws Exception {
		MessageDigest md= MessageDigest.getInstance("SHA1");
		md.reset();
		// e: 5c96e65fcc683d3932513592a5babe22bd64a858
		// f: e1ae3f64e6b93823694059b8d5051d3ad1c05d35
		md.update("Secret123".getBytes());
		byte[] bytes= md.digest();
		BigInteger bi= new BigInteger(1,bytes);
		System.out.println(bi.toString(16));
	}

}
