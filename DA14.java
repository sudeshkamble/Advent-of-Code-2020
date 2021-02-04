package com.sb.demo;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class DA14 {

	static Map<Long,Long> memory2=new HashMap<Long,Long>();
	public static void main(String[] args) throws FileNotFoundException {
		File file = new File("src/main/resources/ferry.info");
		Scanner myReader = new Scanner(file);
		Map<Long,Long> memory=new HashMap<Long,Long>();
		
		String mask="";
		
		while(myReader.hasNextLine()) {
			String data=myReader.nextLine();
			if(data.contains("mask")) {
				mask=data.split("\\s=\\s")[1];
				//System.out.println(mask);
			}
			else {
				long address=Long.parseLong(data.split("\\[")[1].split("\\]")[0].replaceAll("\\[", "").replaceAll(",", ""));
				long value=Long.parseLong(data.split("\\[")[1].split("\\]")[1].replaceAll("\\s", "").replaceAll("=", ""));
				String result = String.format("%36s", Long.toBinaryString(value)).replaceAll(" ", "0");
				//System.out.println(address+" "+value+" "+result);
				long mask_val=maskNumber(result,mask);
				memory.put(address,mask_val);
				address&=Long.parseLong(mask.replace("0", "1").replace("X","0"),2);
				part2(mask,address,value);
				
			}
			
		}
		//System.out.println(memory);
		long sum=0;
		for(long l:memory.values()) {
			sum+=l;
		}
		System.out.println("Part 1:"+sum);
		sum=0;
		for(long l:memory2.values()) {
			sum+=l;
		}
		System.out.println("Part 2:"+sum);
	}

	private static void part2(String mask, long address, long value) {
		//System.out.println("Mask="+mask);
		if(mask.contains("X")) {
			part2(mask.replaceFirst("X", "1"),address,value);
			part2(mask.replaceFirst("X", "0"),address,value);
			
		}
		else {
			long parse=Long.parseLong(mask.toString(), 2);
			long new_address=(parse |address);
			//System.out.println(parse+" "+address+" "+new_address+" "+value);
			memory2.put(new_address,value);
		}
		
	}

	private static long maskNumber(String result, String mask) {
		StringBuilder str=new StringBuilder();
		for(int i=0;i<mask.length();i++) {
			
			if(mask.charAt(i)=='X') {
				str.append(result.charAt(i));
				continue;
			}
			else{
				str.append(mask.charAt(i));
			}
			//str.append(c);
		}
		return Long.parseLong(str.toString(), 2);
		
	}

}
