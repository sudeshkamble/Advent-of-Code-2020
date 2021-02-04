package com.sb.demo;


import java.io.*;
import java.util.*;

public class DA11_2 {
    public static void main(String[] args) throws FileNotFoundException {
        List<List<Character>> map = new ArrayList<>();
        List<Integer> toChange;
        Scanner s = new Scanner(new File("src/main/resources/day11"));
        int height = 0;
        int idcounter = 0;

        while (s.hasNextLine()) {
            String l = s.nextLine();
            map.add(new ArrayList<>());
            for (char a : l.toCharArray()) {
                map.get(height).add(a);
            }
            height++;
        }

        int width = map.get(0).size();

        boolean changed = true;
        while (changed) {
            changed = false;
            toChange = new ArrayList<>();
            for(int i = 0; i < map.size(); i++){
                for (int j = 0; j < map.get(i).size(); j++) {
                    int adjcount = 0;

                    char a = map.get(i).get(j);

                    //upleft
                    int p = i;
                    int q = j;
                    if (p > 0 && q > 0) {
                        do {
                            p--;
                            q--;
                        } while (p > 0 && q > 0 && map.get(p).get(q) == '.');
                    }

                    if (map.get(p).get(q) == '#' && p != i && q != j){
                        adjcount++;
                    }



                    //up
                    p = i;
                    q = j;
                    if (p > 0) {
                        do {
                            p--;
                        } while (p > 0 && map.get(p).get(q) == '.');
                    }

                    if (map.get(p).get(q) == '#' && p != i){
                        adjcount++;
                    }

                    //upright
                    p = i;
                    q = j;
                    if (p > 0 && q < width - 1) {
                        do {
                            p--;
                            q++;
                        } while (p > 0 && q < width - 1 && map.get(p).get(q) == '.');
                    }

                    if (map.get(p).get(q) == '#' && p != i && q != j){
                        adjcount++;
                    }

                    //right
                    p = i;
                    q = j;
                    if (q < width - 1) {
                        do {
                            q++;
                        } while (q < width - 1 && map.get(p).get(q) == '.');
                    }
                    if (map.get(p).get(q) == '#' && q != j){
                        adjcount++;
                    }

                    //downright
                    p = i;
                    q = j;
                    if (p < height - 1 && q < width - 1) {
                        do {
                            p++;
                            q++;
                        } while (p < height - 1 && q < width - 1 && map.get(p).get(q) == '.');
                    }

                    if (map.get(p).get(q) == '#' && p != i && q != j){
                        adjcount++;
                    }
                    //below
                    p = i;
                    q = j;
                    if (p < height - 1) {
                        do {
                            p++;
                        } while (p < height - 1 && map.get(p).get(q) == '.');
                    }
                    if (map.get(p).get(q) == '#' && p != i){
                        adjcount++;
                    }

                    //downleft
                    p = i;
                    q = j;
                    if (p < height - 1 && q > 0) {
                        do {
                            p++;
                            q--;
                        } while (p < height - 1 && q > 0 && map.get(p).get(q) == '.');
                    }

                    if (map.get(p).get(q) == '#' && p != i && q != j){
                        adjcount++;
                    }

                    //left
                    p = i;
                    q = j;
                    if (q > 0) {
                        do {
                            q--;
                        } while (q > 0 && map.get(p).get(q) == '.');
                    }
                    if (map.get(p).get(q) == '#' && q != j){
                        adjcount++;
                    }

                    if ((adjcount == 0 && a == 'L') || (adjcount >= 5 && a == '#')) {
                        toChange.add(i*width+j);
                        changed=true;
                    }
//                    System.out.println(adjcount);
                }
            }

            for (int q : toChange){
                int j = q % width;
                int i = q / width;

                if (map.get(i).get(j) == 'L'){
                    map.get(i).set(j, '#');
                }
                else if (map.get(i).get(j) == '#'){
                    map.get(i).set(j, 'L');
                }
            }

            int count = 0;
            for (int i = 0; i < height; i++){
                for (int j = 0; j < width; j++){
                    if (map.get(i).get(j) == '#'){
                        count++;
                    }
                }
            }
            System.out.println(count);
        }
    }
}