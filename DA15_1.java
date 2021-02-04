package com.sb.demo;

import java.io.*;
import java.util.*;

public class DA15_1 {
    public static void main(String[] args) throws FileNotFoundException {
    	String s="1,0,18,10,19,6";
        String[] input = s.split(",");
        List<Long> sequence = new ArrayList<>();
        long prev = -1;
        for (String i : input){
            sequence.add(prev);
            prev = Integer.parseInt(i);
        }
        while (sequence.size() <= 2020){
            int a = sequence.lastIndexOf(prev);
            long b;
            if (a == -1) {
                b = 0;
            }
            else {
                b = sequence.size()-a;
            }
            sequence.add(prev);
            prev = b;
        }
        System.out.println(sequence.get(2020));
    }
}
