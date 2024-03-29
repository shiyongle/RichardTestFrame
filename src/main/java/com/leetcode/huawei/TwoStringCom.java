package com.leetcode.huawei;

import java.util.Scanner;

public class TwoStringCom {
    public static void main(String[]args){
        Scanner sc=new Scanner(System.in);
        while(sc.hasNext()){
            String s1=sc.nextLine();
            String s2=sc.nextLine();
            longString(s1,s2);
        }
    }
    public static void longString(String s1,String s2){
        String shortStr = s1.length() < s2.length() ? s1 : s2;
        String longStr = s1.length() > s2.length() ? s1 : s2;
        int shortLen = shortStr.length();
        int longLen = longStr.length();
        int maxLen = 0, start = 0;
        for(int i = 0; i < shortLen;i++) {
            // 剪枝，子串长度已经不可能超过maxLen，退出循环
            if(shortLen - i + 1 <= maxLen) {
                break;
            }
            // 左指针j，右指针k, 右指针逐渐向左逼近
            for(int j = i, k = shortLen; k > j; k--) {
                String subStr = shortStr.substring(i, k);
                if(longStr.contains(subStr) && maxLen < subStr.length()) {
                    maxLen = subStr.length();
                    start = j;
                    // 找到就立即返回
                    break;
                }
            }
        }
        System.out.println(shortStr.substring(start, start + maxLen));
    }
}
