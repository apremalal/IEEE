package com.anu.codejam;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Test {
	public static void main(String[] args) {
		ArrayList<Integer> arr = new ArrayList<Integer>();
		arr.add(3);
		arr.add(3);
		arr.remove(new Integer(3));
		System.out.println(arr.toString());
	}
}
