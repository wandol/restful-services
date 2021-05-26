package com.example.restfulservices.config;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class test2 {

    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws Exception {



        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        System.out.println("Hello Goorm! Your input is " + input);


        int mid  = input.length()/2;

        String[] inputs = input.split("");

        if((inputs.length % 2) == 0) {
            for (int i = 0; i < mid; i++) {
                System.out.print(inputs[i] + inputs[(inputs.length - 1)  - i]);
            }
        }else{
            for (int i = 0; i < mid; i++) {
                System.out.print(inputs[i] + inputs[(inputs.length - 1)  - i]);
                if(i == mid - 1){
                    System.out.print(inputs[mid]);
                }
            }
        }


    }
}
