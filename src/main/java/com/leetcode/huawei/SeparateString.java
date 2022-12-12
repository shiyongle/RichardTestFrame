package com.leetcode.huawei;

import java.util.Scanner;

/**
 * @Descriotion 字符串分隔
 * @Date 2022/5/9 14:47
 * @Created by shiyl
 */
public class SeparateString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()){
            String s = sc.nextLine();
            split(s);
        }
    }

    private static void split(String s) {
        while (s.length() >= 8){
            System.out.println(s.substring(0,8));
            s = s.substring(8);
        }
        if (s.length() <8 && s.length()>0){
            s+="00000000";
            System.out.println(s.substring(0,8));
        }
    }
}
