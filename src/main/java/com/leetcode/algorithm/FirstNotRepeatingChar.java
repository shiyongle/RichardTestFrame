package com.leetcode.algorithm;

/**
 * @Descriotion 字符串中第一个只出现一次的字符
 * @Date 2022/5/7 0:21
 * @Created by shiyl
 */
public class FirstNotRepeatingChar {
    public char firstNotRepeatingChar(String str) {
        if(str==null)
            return '\0';
        int[] repetitions = new int[256];
        for(int i=0;i<256;i++)
            repetitions[i]=0;
        for(int i=0;i<str.length();i++) {
            int loc=(int) str.charAt(i);
            repetitions[loc]+=1;
        }
        for(int i=0;i<str.length();i++) {
            int loc=(int) str.charAt(i);
            if(repetitions[loc]==1)
                return (char)loc;
        }
        return '\0';
    }

    public static void main(String[] args) {
        FirstNotRepeatingChar demo =new FirstNotRepeatingChar();
        System.out.println((demo.firstNotRepeatingChar("google")=='l'));
        System.out.println((demo.firstNotRepeatingChar("aabccdbd")=='\0'));
        System.out.println((demo.firstNotRepeatingChar("$abcdefg")=='$'));
        System.out.println((demo.firstNotRepeatingChar(null)=='\0'));
    }
}
