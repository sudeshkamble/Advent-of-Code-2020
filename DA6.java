package com.sb.demo;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class DA6 {

	public static void main(String[] args) throws FileNotFoundException {
		File file = new File("src/main/resources/customs.info");
		Scanner myReader = new Scanner(file);
		ArrayList<String> customsList = new ArrayList<String>();
		String customs = "";
		int i = 0;
		while (myReader.hasNextLine()) {
			String data = myReader.nextLine();
			// System.out.println(i + " " + data + " " + data.length());
			if (data.length() != 0) {
				customs = customs + data + " ";
			} else {

				customsList.add(customs);
				customs = "";
			}
			i++;
		}
		customsList.add(customs);

		int yesCount = 0;
		System.out.println(customsList);
		int allPresentCount=0;
		for (String custom : customsList) {
			HashSet<Character> yes = new HashSet<Character>();
			String[] customSplit = custom.split("\\s");
			
			for (char ansL = 'a'; ansL <= 'z'; ansL++) {
				boolean presentAll = true;
				for (String ans : customSplit) {
					if (!ans.contains(Character.toString(ansL))) {
						presentAll = false;
						break;
					}

				}
				if (presentAll == true) {
					allPresentCount++;
				}
			}
			

		}
		System.out.println(allPresentCount);

	}

}
