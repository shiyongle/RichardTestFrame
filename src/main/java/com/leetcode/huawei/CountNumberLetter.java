package com.leetcode.huawei;

import java.util.Scanner;

/**
 * 统计大写字母个数
 */
public class CountNumberLetter {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            System.out.println(in.nextLine().replaceAll("[^A-Z]","").length());
        }
    }
}
