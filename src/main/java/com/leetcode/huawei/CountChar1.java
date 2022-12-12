package com.leetcode.huawei;

import java.util.Scanner;

/**
 * 统计字符
 * 输入一行字符，分别统计出包含英文字母、空格、数字和其它字符的个数。
 * 数据范围：输入的字符串长度满足 1 \le n \le 1000 \1≤n≤1000
 */
public class CountChar1 {
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner in=new Scanner(System.in);
        while(in.hasNext()){
            String str=in.nextLine();
            String s1=str.replaceAll("[A-Z]+|[a-z]+", "");
            System.out.println(str.length()-s1.length());
            String s2=s1.replaceAll(" ", "");
            System.out.println(s1.length()-s2.length());
            String s3=s2.replaceAll("[0-9]+", "");
            System.out.println(s2.length()-s3.length()+"\n"+s3.length());
        }
    }
}
