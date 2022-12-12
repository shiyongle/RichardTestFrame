package com.leetcode.huawei;


import java.util.Scanner;

/**
 * @Descriotion 提取不重复的整数
 * @Date 2022/5/9 14:47
 * @Created by shiyl
 */
public class NonRepeatingInteger {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        char[] chars = (num+"").toCharArray();
        String str = "";
        for (int i= chars.length-1; i>=0; i--){
            if (!str.contains(chars[i] + "")){
                str += chars[i];
            }
        }
        System.out.println(Integer.valueOf(str));
    }
}
