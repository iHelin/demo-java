package me.ianhe.test;

import java.math.BigInteger;
import java.util.Random;

public class Test6 {
	public static void main(String[] args) {
		Random rdm = new Random();
		System.out.println(rdm.nextInt(10));
		BigInteger i = BigInteger.probablePrime(10, rdm);
		System.out.println(i);
		String b = "True";
		Boolean a = Boolean.valueOf(b);
		System.out.println(a);
	}

}
