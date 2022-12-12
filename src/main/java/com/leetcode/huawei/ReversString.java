package com.leetcode.huawei;

import java.util.Scanner;

/**
 * 字符串反转
 */
public class ReversString {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            String str = sc.nextLine();
            char[] chars = str.toCharArray();
            for (int i = chars.length-1; i>=0; i--){
                System.out.println(chars[i]);
            }
            System.out.println();
        }
    }
}
