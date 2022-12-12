package com.demo;

import java.util.Scanner;

public class CountString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input1 = sc.nextLine();
        String input2 = sc.nextLine();
        String split3 = input1.toUpperCase().replaceAll(input2.toUpperCase(), "");
        System.out.println(input1.length() - split3.length());
    }
}
