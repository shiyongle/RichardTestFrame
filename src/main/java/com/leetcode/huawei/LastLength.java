package com.leetcode.huawei;

import java.util.Scanner;

/**
 * @Descriotion zui最后一个字符串的长度
 * @Date 2022/5/9 14:47
 * @Created by shiyl
 */
public class LastLength {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String[] s = str.split(" ");
        int length = s[s.length-1].length();
        System.out.println("最后一位字符串的长度为：" + length);
    }
}
