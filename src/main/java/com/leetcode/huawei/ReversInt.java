package com.leetcode.huawei;

import java.util.Scanner;

/**
 * 数字颠倒
 */
public class ReversInt {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str =sc.nextLine();
        StringBuffer strb = new StringBuffer(str);
        strb.reverse();
        System.out.println (strb.toString());
    }
}
