package com.sb.demo;
import java.io.*;
import java.util.*;

public class DA11_1 {
    public static void main(String[] args) throws FileNotFoundException {
        Map<Integer, Character> map = new HashMap<>();
        List<Integer> toChange;
        Scanner s = new Scanner(new File("src/main/resources/day11"));
        int width = 0;
        int height = 0;
        int idcounter = 0;

        while (s.hasNextLine()) {
            String l = s.nextLine();

            //Determine width and height
            width = l.length();
            height++;
            for (char i : l.toCharArray()){
                map.put(idcounter, i);
                idcounter++;
            }
        }

        Boolean changed = true;
        while (changed) {
            toChange = new ArrayList<>();
            changed = false;
            for (int i = 0; i < map.size(); i++) {
                int adjcounter = 0;
                char a = map.get(i);
                if (a != '.' && i % width != 0 && i % width != width - 1) {
                    for (int j = -1; j < 2; j++) {
                        for (int k = -1; k < 2; k++) {
                            if (map.containsKey((i + j * width + k)) && i + j * width + k != i) {
                                if (map.get(i + j * width + k) == '#') {
                                    adjcounter++;
                                }
                            }
                        }
                    }
                } else if (a != '.' && i % width == 0) {
                    for (int j = -1; j < 2; j++) {
                        for (int k = 0; k < 2; k++) {
                            if (map.containsKey((i + j * width + k)) && i + j * width + k != i) {
                                if (map.get(i + j * width + k) == '#') {
                                    adjcounter++;
                                }
                            }
                        }
                    }
                } else if ((a != '.' && i % width == width - 1)) {
                    for (int j = -1; j < 2; j++) {
                        for (int k = -1; k < 1; k++) {
                            if (map.containsKey((i + j * width + k)) && i + j * width + k != i) {
                                if (map.get(i + j * width + k) == '#') {
                                    adjcounter++;
                                }
                            }
                        }
                    }
                }
                if ((adjcounter == 0 && a == 'L') || (adjcounter >= 4 && a == '#')) {
                    toChange.add(i);
                    changed=true;
                }
            }

            for (int q : toChange) {
                if (map.get(q) == 'L') {
                    map.put(q, '#');
                } else if (map.get(q) == '#') {
                    map.put(q, 'L');
                }
            }

            int count = 0;
            for(int i = 0; i < map.size(); i++){
                if (map.get(i) == '#'){
                    count++;
                }
            }
            System.out.println(count);
        }
    }
}