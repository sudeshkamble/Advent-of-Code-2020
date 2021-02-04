package com.sb.demo;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;
public class DA21_2 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner s = new Scanner(new File("src/main/resources/day21"));
        Map<String, List<String>> map = new HashMap<>();
        Map<String, Integer> all = new HashMap<>();
        while(s.hasNextLine()) {
            String[] parts = s.nextLine().split(" \\(contains ");
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
                if (!map.containsKey(a)) map.put(a, ingredients);
                else {
                    List<String> poss = map.get(a);
                    List<String> res = poss.stream().filter(ingredients::contains).collect(Collectors.toList());
                    map.put(a, res);
                }
            }
        }
        for (int i = 0; i < 20; i++){
            for (List<String> l : map.values()){
                if (l.size() == 1){
                    for (String p : map.keySet()){
                        if(map.get(p) != l) {
                            map.get(p).remove(l.get(0));
                        }
                    }
                }
            }
        }
        List<String> ordered = new ArrayList<>(map.keySet());
        Collections.sort(ordered);
        StringBuilder result = new StringBuilder();
        for(String i : ordered){
            result.append(map.get(i).get(0)).append(",");
        }
        System.out.println(result.substring(0, result.length()-1));
    }
}