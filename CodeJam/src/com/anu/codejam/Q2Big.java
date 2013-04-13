package com.anu.codejam;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigInteger;

public class Q2Big {
	public static boolean notCompletedLine = false;
	public static int square = 0;
	private static final BigInteger TWO = BigInteger.valueOf(2);
	private static final BigInteger THREE = BigInteger.valueOf(3);
	private static BigInteger SQRT;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(new File(
				"C-large-1.in")));
		BufferedWriter brr = new BufferedWriter(new FileWriter(new File(
				"out.in")));
		String line = br.readLine();
		int N = Integer.parseInt(line);
		System.out.println(N);
		int count = 0;
		boolean found = false;
		for (int i = 0; i < N; i++) {
			found = false;
			String s[] = br.readLine().split("\\D");
			BigInteger lower = new BigInteger(s[0]);
			BigInteger upper = new BigInteger(s[1]);

			square = 0;
			count = 0;
			for (BigInteger j = lower; j.compareTo(upper) <= 0; j = found ? j.add(THREE) : j.add(BigInteger.ONE)) {
				if (isPalindrom(("" + j).toCharArray())) {
					if (isSquare(j)) {
						if (isPalindrom(("" + SQRT).toCharArray())) {
							count++;
							found = true;
							System.out.println(j);
						} 
					}
					else
						found = false;
				}
			}
			brr.write("Case #" + (i + 1) + ": " + count + "\n");
		}
		brr.flush();
		brr.close();
	}

	public static boolean isSquare(BigInteger j) {
		SQRT = sqrt(j);
		return SQRT.pow(2).equals(j);
	}

	/**
	 * Computes the integer square root of a number.
	 * 
	 * @param n
	 *            The number.
	 * 
	 * @return The integer square root, i.e. the largest number whose square
	 *         doesn't exceed n.
	 */
	public static BigInteger sqrt(BigInteger n) {
		if (n.signum() >= 0) {
			final int bitLength = n.bitLength();
			BigInteger root = BigInteger.ONE.shiftLeft(bitLength / 2);

			while (!isSqrt(n, root)) {
				root = root.add(n.divide(root)).divide(TWO);
			}
			return root;
		} else {
			throw new ArithmeticException("square root of negative number");
		}
	}

	private static boolean isSqrt(BigInteger n, BigInteger root) {
		final BigInteger lowerBound = root.pow(2);
		final BigInteger upperBound = root.add(BigInteger.ONE).pow(2);
		return lowerBound.compareTo(n) <= 0 && n.compareTo(upperBound) < 0;
	}

	public static boolean isPalindrom(char[] word) {
		int i1 = 0;
		int i2 = word.length - 1;
		while (i2 > i1) {
			if (word[i1] != word[i2]) {
				return false;
			}
			++i1;
			--i2;
		}
		return true;
	}
}
