package com.leetcode.huawei;

import java.util.Scanner;

/**
 * 截取字符串
 */
public class InterceptString {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            // 输入字符串和k
            String str = sc.next();
            int k = sc.nextInt();
            // 直接使用String的substring方法输出结果
            System.out.println(str.substring(0,k));
        }
    }
}
