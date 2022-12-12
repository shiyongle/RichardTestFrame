package com.demo;

import java.util.Scanner;

public class LastLength {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String string = sc.nextLine();
        String[] s = string.split(" ");
        int length = s[s.length - 1].length();
        System.out.println(length);
    }
}
