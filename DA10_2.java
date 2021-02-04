package com.sb.demo;

import java.io.*;
import java.util.*;

public class DA10_2 {
	public static void main(String[] args) throws FileNotFoundException {
		List<Integer> input = new ArrayList<>();
		int[] tribonacci = { 0, 1, 1, 2, 4, 7, 13 };

		Scanner s = new Scanner(new File("src/main/resources/day10"));
		while (s.hasNextLine()) {
			String l = s.nextLine();
			input.add(Integer.parseInt(l));
		}

		Collections.sort(input);
		input.add(input.get(input.size() - 1) + 3);

		int prev = 0;
		long result = 1;
		int consecutiveCount = 1;

		for (int i : input) {
			if (i == prev + 1) {
				consecutiveCount++;
			} else {
				result *= tribonacci[consecutiveCount];
				consecutiveCount = 1;
			}
			prev = i;
		}
		System.out.println(result);

	}
}