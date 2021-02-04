package com.sb.demo;

import java.io.FileNotFoundException;

public class DA23 {

	private static String input;

	public static void main(String[] args) throws FileNotFoundException {

		input = "952316487";

		part1();
		part2();

	}

	public static void part1() {
		// In a circular structure, every number points to a successor.
		// example: "389125467"
		// means 3->8, 8->9, 9->1, ..., 6->7, 7->3
		// rearranged: 1->2, 2->5, 3->8, ... , 8->9, 9->1
		// Create an array of length 10 where the index is a number and it's element is
		// what it points to.
		// So, given our example, we would have the int[] {0, 2, 5, 8, 6, 4, 7, 3, 9, 1}
		// note: element 0 points to itself and will never be used
		int[] cups = new int[10];
		for (int i = 0; i <= input.length() - 2; i++) {
			cups[Integer.parseInt(input.substring(i, i + 1))] = Integer.parseInt(input.substring(i + 1, i + 2));
		}
		cups[Integer.parseInt(input.substring(input.length() - 1))] = Integer.parseInt(input.substring(0, 1));

		cups = playTheGame(100, cups);

		// Starting with the element that 1 points to, create a string with each element
		// followed by the element that it points to, ending when you get to 1
		String answer = "";
		int i = 1;
		do {
			answer += cups[i];
			i = cups[i];
		} while (i != 1);

		// cut off the last '1' from the answer
		answer = answer.substring(0, answer.length() - 1);

		System.out.println("Final position of cups: " + answer);

	}

	public static void part2() {
		// see explanation of int[] in part 1
		int[] cups = new int[1_000_001];
		int i = 0;
		for (i = 0; i <= input.length() - 2; i++) {
			cups[Integer.parseInt(input.substring(i, i + 1))] = Integer.parseInt(input.substring(i + 1, i + 2));
		}
		cups[Integer.parseInt(input.substring(i, i + 1))] = 10;
		for (i = 10; i <= 1_000_000; i++) {
			cups[i] = i + 1;
		}
		cups[1_000_000] = Integer.parseInt(input.substring(0, 1));

		cups = playTheGame(10_000_000, cups);

		// find the number that 1 points to and the number that that number points to
		long answer = (long) cups[1] * cups[cups[1]];

		System.out.println("Part 2: " + answer);

	}

	/**
	 * Plays the game of Crab Cups with a given number of moves to make and an array
	 * of integers representing the sequence of cups
	 * 
	 * @param moves The number of moves to be played in the game
	 * @param cups  Array of integers
	 * @return The modified cups array
	 */
	public static int[] playTheGame(int moves, int[] cups) {

		// start with the first cup in the input string
		int cup = Integer.parseInt(input.substring(0, 1));
		for (int m = 1; m <= moves; m++) {
			// grab the three cups that succeed 'cup'
			int a = cups[cup];
			int b = cups[a];
			int c = cups[b];
			int dest = cup - 1;
			// circle 'dest' back around to the highest number in the array
			// if it gets too low
			if (dest <= 0)
				dest = cups.length - 1;
			// decrement 'dest' in the event that it equals one of the three relocating cups
			while (dest == a || dest == b || dest == c) {
				dest--;
				if (dest <= 0)
					dest = cups.length - 1;
			}

			// at this point, we just have to reassign three values...
			// 'cup' should now point to what 'c' was pointing at
			// 'dest' should now point at 'a'
			// 'c' should now point at what 'dest' was pointing
			// note: 'a' still points at 'b' and 'b' still points at 'c'
			// these elements of the array are NOT affected
			cups[cup] = cups[c];
			int temp = cups[dest];
			cups[dest] = a;
			cups[c] = temp;
			cup = cups[cup];

		}

		return cups;
	}

}
// 82934675, 474600314018