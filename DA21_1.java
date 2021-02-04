package com.sb.demo;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.stream.Collectors;

public class DA21_1 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner s = new Scanner(new File("src/main/resources/day21"));
        Map<String, List<String>> map = new HashMap<>();
        Map<String, Integer> all = new HashMap<>();
        while(s.hasNextLine()) {
            String l = s.nextLine();
            String[] parts = l.split(" \\(contains ");
            parts[1] = parts[1].substring(0, parts[1].length() - 1);
            List<String> ingredients = Arrays.asList(parts[0].split(" "));
            String[] allergies = parts[1].split(", ");
            for(String in : ingredients){
                if (all.containsKey(in)){
                    all.put(in, all.get(in)+1);
                }
                else {
                    all.put(in, 1);
                }
            }
            for (String a : allergies) {
                if (!map.containsKey(a)) {
                    map.put(a, ingredients);
                } else {
                    List<String> poss = map.get(a);
                    List<String> res = poss.stream().filter(ingredients::contains).collect(Collectors.toList());
                    map.put(a, res);
                }
            }
        }
        Set<String> al = new HashSet<>();
        for (List<String> z : map.values()){
            al.addAll(z);
        }
        int count = 0;
        for(String p : all.keySet()){
            if(!al.contains(p)){
                count += all.get(p);
            }
        }
        System.out.println(count);
    }
}