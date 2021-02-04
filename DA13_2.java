package com.sb.demo;

import java.io.*;
import java.util.*;

public class DA13_2 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner s = new Scanner(new File("src/main/resources/day13"));
        long time = Long.parseLong(s.nextLine());

        String[] input = s.nextLine().split(",");
        long index = 0;
        long add = 1;

        while(true) {
            if (input[(int) index].equals("x")) {
                index++;
                continue;
            }
            long value = Long.parseLong(input[(int)index]);
            if ((time + index) % value == 0) {
                add = value * add;
                index++;
            }
            if (index == input.length){
                System.out.println(time);
                return;
            }
            time = time + add;
        }
    }
}
