package com.sb.demo;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;

public class DA7 {

	static Set<String> ans = new HashSet<String>();
	static int level = 1;
	static int product = 0;

	public static void main(String[] args) throws FileNotFoundException {
		Map<String, Set<String>> bagRuleList = new HashMap<String, Set<String>>();
		File file = new File("src/main/resources/bags.info");
		Scanner myReader = new Scanner(file);

		int i = 0;
		while (myReader.hasNextLine()) {
			
			String bagRule = myReader.nextLine();
			System.out.println(bagRule);
			bagRule = bagRule.replaceAll("bags.", "").replaceAll("bags", "").replaceAll("bag.", "")
					.replaceAll("bag", "").trim();
			// System.out.println(i + " " + data + " " + data.length());

			System.out.println(bagRule);
			String key = bagRule.split("\\scontain\\s")[0];
			String map[] = bagRule.split("\\scontain\\s")[1].split("\\s\\s");
			Set<String> mapping = new HashSet<String>(Arrays.asList(map));
			bagRuleList.put(key, mapping);
			System.out.println(key + "=" + Arrays.toString(map) + " " + map.length);

		}
		int validPassports = 0;
		// System.out.println("======================");
		// System.out.println("List=" + bagRuleList.toString());

		System.out.println(bagRuleList);
		System.out.println(getMapping(bagRuleList, "shiny gold"));

	}

	static int getMapping(Map<String, Set<String>> dict, String color) {

//		int retVal = 1;
//		int newValue=0;
//		for (Entry<String, Set<String>> entry : bagRuleList.entrySet()) {
//			Set<String> map = entry.getValue();
//			String key = entry.getKey();
//			if (key.equals(bagColor)) {
//				for (String str : map) {
//
//					// ans.add(key);
//					System.out.println("Key = " + key + ", Value = " + str);
//					int value = Integer.parseInt(str.split("\\s")[0]);
//					System.out.println("Value:" + value + " Level:" + level);
//					if (value != 0) {
//						level++;
//						retVal=getMapping(str.replace(str.split("\\s")[0] + " ", ""), bagRuleList,value);
//						newValue=parentValue+value*retVal+newValue;
//						//newValue=retVal+parentValue;
//						//product=product+newValue;
//						System.out.println("Val:"+retVal+" Value:"+value+" ParentValue:"+parentValue +" New Value:"+newValue+" Product:"+product);
//						
//						
//					} else {
//						
//						level--;
//						return 1;
//					}
//
//				}
//			}
//		}

		int count = 0;
		for (String s : dict.get(color)) {

			System.out.println(s);
			if (s.equals("no other")) {
				continue;
			}
			String copy = s;
			int numberOfBags = Integer.parseInt(copy.replaceAll("[^\\d]", ""));
			count = count + numberOfBags + numberOfBags * getMapping(dict, s.replaceAll("\\d", "").trim());
		}

		return count;
		// return newValue;

	}
}
