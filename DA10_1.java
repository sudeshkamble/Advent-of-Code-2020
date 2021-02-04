package com.sb.demo;

import java.util.Arrays;

public class DA10_1 {

	public static void main(String[] args) {
		 int input1[] = { 16, 10, 15, 5, 1, 11, 7, 19, 6, 12, 4 };
		int input[] = { 104, 83, 142, 123, 87, 48, 102, 159, 122, 69, 127, 151, 147, 64, 152, 90, 117, 132, 63, 109, 27,
				47, 7, 52, 59, 11, 161, 12, 148, 155, 129, 10, 135, 17, 153, 96, 3, 93, 82, 55, 34, 65, 89, 126, 19, 72,
				20, 38, 103, 146, 14, 105, 53, 77, 120, 39, 46, 24, 139, 95, 140, 33, 21, 84, 56, 1, 32, 31, 28, 4, 73,
				128, 49, 18, 62, 81, 66, 121, 54, 160, 158, 138, 94, 43, 2, 114, 111, 110, 78, 13, 99, 108, 141, 40, 25,
				154, 26, 35, 88, 76, 145 };
		
		Arrays.sort(input);
		System.out.println(Arrays.toString(input));
		int diff3 = 0;
		int diff1 = 0;
		int init = 0;

		int diff = Math.abs(init - input[0]);
		System.out.println(init + " " + input[0] + " " + diff);
		if (diff == 3)
			diff3++;
		else
			diff1++;
		for (int i = 0; i < input.length - 1; i++) {
			diff = Math.abs(input[i] - input[i + 1]);
			System.out.println(input[i] + " " + input[i + 1] + " " + diff);
			if (diff == 3)
				
				diff3++;
			else
				diff1++;
		}
		diff3++;
		System.out.println(diff1 + " " + diff3 + " " + diff3 * diff1);

	}

}
