package com.sb.demo;

import java.util.List;


public class DA25 {

    

    public static void main(String[] args) {
        int cardPub = 12232269;
        		
        int doorPub = 19452773;

        long v = 1;
        int i = 0;
        while (v != cardPub) {
            v = (7 * v) % 20201227;
            i++;
        }
        //System.out.println(i + " " + v);

        v = 1;
        for (int j = 0; j < i; j++) {
            v = (doorPub * v) % 20201227;
        }
        System.out.println("part 1:"+ v);
    }
}
