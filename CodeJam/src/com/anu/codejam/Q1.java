package com.anu.codejam;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q1 {
	public static boolean notCompletedLine = false;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = br.readLine();
		int N = Integer.parseInt(line);
		System.out.println("");
		System.out.println("------------------");
	
		char arr[][] = new char[4][4];
		for (int i = 0; i < N+1; i++) {
			for (int j = 0; j < 4; j++) {
				arr[j] = br.readLine().toCharArray();
			}
			checkCombinations(arr, i);
			br.readLine();
		}
	}

	private static void checkCombinations(char[][] arr, int x) {
		String s = null;
		notCompletedLine = false;
		// horizontal
		for (int i = 0; i < 4; i++) {
			s = new String(arr[i]);
			if (checkRules(s, x))
				return;
		}
		// verticle
		for (int j = 0; j < 4; j++) {
			s = arr[0][j] + "" + arr[1][j] + "" + arr[2][j] + "" + arr[3][j];
			if (checkRules(s, x))
				return;
		}

		s = arr[0][0] + "" + arr[1][1] + "" + arr[2][2] + "" + arr[3][3];
		if (checkRules(s, x))
			return;

		s = arr[0][3] + "" + arr[1][2] + "" + arr[2][1] + "" + arr[3][0];
		if (checkRules(s, x))
			return;

		if (notCompletedLine) {
			System.out.println("Case #" + (x + 1) + ": Game has not completed");
		} else {
			System.out.println("Case #" + (x + 1) + ": Draw");
		}
	}

	private static boolean checkRules(String s, int x) {
		if (s.contains(".")) {
			notCompletedLine = true;
			return false;
		}
		if (s.equals("XXXX") || (!s.contains("O") & s.contains("T"))) {
			System.out.println("Case #" + (x + 1) + ": X won");
			return true;
		} else if ((!s.contains("X") & s.contains("T")) || s.equals("OOOO")) {
			System.out.println("Case #" + (x + 1) + ": O won");
			return true;
		}
		return false;
	}
}
