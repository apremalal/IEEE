package com.anu.codejam;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Q2 {
	public static boolean notCompletedLine = false;
	public static int square = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = br.readLine();
		int N = Integer.parseInt(line);
		System.out.println();
		int count = 0;
		for (int i = 0; i < N; i++) {
			String s[] = br.readLine().split("\\D");
			int upper = Integer.parseInt(s[1]);
			int lower = Integer.parseInt(s[0]);
			square = 0;
			count = 0;
			for (int j = lower; (j <= upper); j++) {
				if (isPalindrom(("" + j).toCharArray()) && isSquare(j)) {
					if (isPalindrom(("" + (int) Math.sqrt(j)).toCharArray())) {
						count++;
					}
				}
			}
			System.out.println("Case #" + (i + 1) + ": " + count);
		}

	}

	public static boolean isSquare(double j) {
		return Math.sqrt(j) % 1d == 0d;
	}

	/*
	 * public static boolean isBigSquare(BigInteger j) {
	 * 
	 * return Math.sqrt(j) % 1 == 0; }
	 */

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
