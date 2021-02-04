package com.sb.demo;

import java.io.*;
import java.util.*;

public class DA18_1 {
    public static void main(String[] args) throws FileNotFoundException {
    	File file = new File("src/main/resources/day18");
    	Scanner s = new Scanner(file);
        long result = 0;
        
        while (s.hasNextLine()) {
            Stack<StringBuilder> a = new Stack<>();
            String l = s.nextLine();

            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < l.length(); i++){
                if (l.charAt(i) == '('){
                    a.push(sb);
                    sb = new StringBuilder();
                }
                else if (l.charAt(i) == ')'){
                    String ex = sb.toString();
                    String p = calc(ex);
                    sb = a.pop();
                    sb.append(p);
                }
                else {
                    sb.append(l.charAt(i));
                }
            }
            String res = calc(sb.toString());
            result += Long.parseLong(res);
        }
        System.out.println(result);
    }

    public static String calc(String ex){
        String[] c = ex.split(" ");
        long accum = Long.parseLong(c[0]);
        for (int i = 2; i < c.length; i = i+2){
            int to = Integer.parseInt(c[i]);
            switch (c[i - 1]) {
                case "+" : accum += to;
                			break;
                case "*" : accum *= to;
                			break;
            }
        }
        return Long.toString(accum);
    }

}
		
		