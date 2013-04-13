package com.anu.codejam;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Treasure {
	public static ArrayList<Integer> allKeys = null;
	public static ArrayList<Integer> requiredKeys = null;
	public static ArrayList<Integer> treasureKeys = null;
	public static ArrayList<Integer> startingKeys = null;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		System.out.println("\n------------------");
		int n_startingkeys = 0, n_chest = 0;
		for (int i = 0; i < N; i++) {
			String s[] = br.readLine().split("\\D");
			n_startingkeys = Integer.parseInt(s[0]);
			n_chest = Integer.parseInt(s[1]);

			startingKeys = new ArrayList<Integer>(); // starting
			allKeys = new ArrayList<Integer>(); // All keys
			requiredKeys = new ArrayList<Integer>();
			treasureKeys = new ArrayList<Integer>();

			String s2[] = br.readLine().split("\\D");
			for (int t = 0; t < n_startingkeys; t++) {
				startingKeys.add(Integer.parseInt(s2[t]));
				allKeys.add(Integer.parseInt(s2[t]));
			}

			ArrayList<Chest> chests = new ArrayList<Chest>();
			for (int j = 0; j < n_chest; j++) {
				String s3[] = br.readLine().split("\\D");
				chests.add(new Chest(Integer.parseInt(s3[0]), getKeys(s3,
						Integer.parseInt(s3[1])), j + 1));
				requiredKeys.add(Integer.parseInt(s3[0]));
			}

			boolean impossible = false;
			if (firstpossibility()) {
				allKeys.addAll(treasureKeys);
				if (isPossible()) {
					Collections.sort(startingKeys);

				} else {
					System.out.println("Case #" + (i + 1) + ": IMPOSSIBLE");
					continue;
				}
			} else {
				System.out.println("Case #" + (i + 1) + ": IMPOSSIBLE");
				continue;
			}

			// printChests(chests);
		}
	}

	private static boolean firstpossibility() {
		for (int x : allKeys) {
			if (requiredKeys.contains(new Integer(x)))
				return true;
		}
		return false;
	}

	private static boolean isPossible() {
		for (int x : requiredKeys) {
			if (!allKeys.contains(new Integer(x))) {
				return false;
			}
		}
		return true;
	}

	private static void printChests(ArrayList<Chest> chests) {
		for (Chest chest : chests) {
			System.out.println(chest);
		}

	}

	private static int[] getKeys(String[] s3, int n) {
		int keys[] = new int[n];
		for (int i = 0; i < n; i++) {
			keys[i] = Integer.parseInt(s3[i + 2]);
			treasureKeys.add(keys[i]);
		}
		return keys;
	}
}

class Chest {
	int chestId;
	int keyToOpen;
	int keysInside[];

	public Chest(int keyToOpen, int[] keysInside, int chestId) {
		this.keyToOpen = keyToOpen;
		this.keysInside = keysInside;
		this.chestId = chestId;
	}

	@Override
	public String toString() {
		return "{" + "chestID: " + chestId + " keyToOpen:" + keyToOpen
				+ " keysInside:" + Arrays.toString(keysInside) + "}";
	}
}