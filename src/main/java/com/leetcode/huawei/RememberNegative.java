package com.leetcode.huawei;

import java.util.Scanner;

/**
 * 记负均正
 */
public class RememberNegative {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            int countNegative = 0;
            int countPositive = 0;
            int sum = 0;
            for (int i = 0; i < n; i++) {
                int number = sc.nextInt();
                if (number < 0) {
                    countNegative++;
                } else if (number > 0){
                    sum += number;
                    countPositive++;
                }
            }
            System.out.println(countNegative + " " + String.format("%.1f", sum * 1.0 / countPositive));
        }
        sc.close();
    }
}
