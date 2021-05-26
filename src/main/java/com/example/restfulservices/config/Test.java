package com.example.restfulservices.config;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Test {

    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws Exception {

        int N = Integer.parseInt(scanner.next());
        int s = Integer.parseInt(scanner.next());
        String firstTxt = scanner.next();

        String[] result = new String[s];

        for (int i = 0; i < s; i++) {
            int min = Integer.parseInt(scanner.next());
            int max = Integer.parseInt(scanner.next());
            System.out.println(min);
            System.out.println(max);
            String txt = firstTxt.substring(min - 1,max - 1);
            System.out.println("txt :: " + txt);
            String[] searchTxt = txt.split("");

            Map<String, Integer> map = new HashMap<>();

            for (int k = 0; k < searchTxt.length; k++) {
                if(map.containsKey(searchTxt[k])){
                    map.put(searchTxt[k], map.get(searchTxt[k]) + 1);
                }else{
                    map.put(searchTxt[k], 1);
                }
            }
            map.forEach((k,v) -> System.out.println(k+"="+v));
            List<Map.Entry<String, Integer>> list = new ArrayList<>(map.entrySet());
            list.sort(Map.Entry.comparingByValue());
            list.forEach(System.out::println);
            result[i] = list.get(list.size() - 1).getKey();

        }
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }
    }

}

        //  30 5
        //  AAAAABBBBBBCDDEFIJLMPQRSTUVWYZ
        //  11 12
        //  7 24
        //  12 23
        //  13 29
        //  1 19