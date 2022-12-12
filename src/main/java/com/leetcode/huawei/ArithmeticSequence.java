package com.leetcode.huawei;

import java.util.Scanner;

/**
 * 等差数列
 */
public class ArithmeticSequence {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int length = sc.nextInt(); // n
            int first = 2, last = 3 * length - 1; // a1, an
            System.out.println((first + last) * length / 2);
        }
        sc.close();
    }
}
