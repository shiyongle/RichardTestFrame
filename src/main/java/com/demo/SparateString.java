package com.demo;

import java.util.Scanner;

public class SparateString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            String s = sc.nextLine();
            split(s);
        }
    }

    private static void split(String s){
        while (s.length() >= 8){
            System.out.println(s.substring(0, 8));
        }
        if (s.length() < 8 && s.length() > 8){
            s+= "00000000";
            System.out.printf("", s.substring(0, 8));
        }
    }
}
