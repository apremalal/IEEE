package com.anu.codejam;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class LandMower {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		int m = 0, n = 0;
		System.out.println();
		for (int i = 0; i < N; i++) {
			String s[] = br.readLine().split("\\D");
			m = Integer.parseInt(s[0]);
			n = Integer.parseInt(s[1]);
			int arr[][] = new int[m][n];
			for (int j = 0; j < m; j++) {
				String s2[] = br.readLine().split("\\D");
				for (int k = 0; k < n; k++) {
					arr[j][k] = Integer.parseInt(s2[k]);
				}
			}
			if (canProcess(arr))
				System.out.println("Case #" + (i + 1) + ": YES");
			else
				System.out.println("Case #" + (i + 1) + ": NO");
			// System.out.println();
			// printArray(arr);
		}
	}

	private static boolean canProcess(int[][] arr) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[0].length; j++) {
				int hor[] = arr[i].clone();
				hor[j] = -1;
				int ver[] = getVerticelColumn(arr, j);
				ver[i] = -1;
				boolean horfailed = false;
				boolean verfailed = false;
				for (int k = 0; k < hor.length; k++) {
					if (hor[k]!=-1 && hor[k] > arr[i][j]) {
						horfailed = true;
						break;
					}

				}
				for (int t = 0; t < ver.length; t++) {
					if (ver[t]!=-1 && ver[t] > arr[i][j]) {
						verfailed = true;
						break;
					}
				}
				if(horfailed && verfailed)
					return false;

			}
		}
		return true;
	}

	private static int[] getVerticelColumn(int[][] arr, int j) {
		int verColumn[] = new int[arr.length];
		for (int i = 0; i < arr.length; i++) {
			verColumn[i] = arr[i][j];
		}
		return verColumn;
	}

	private static void printArray(int[][] arr) {
		for (int[] arr2 : arr) {
			System.out.println(Arrays.toString(arr2));
		}

	}
}
