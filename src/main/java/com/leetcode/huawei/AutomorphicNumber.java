package com.leetcode.huawei;

import java.util.Scanner;

/**
 * 自守数
 */
public class AutomorphicNumber {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int n = sc.nextInt();
            int count = 0;
            for(int i=0;i<=n;i++){
                int sum =i*i;
                String s1 = String.valueOf(i);
                String s2 = String.valueOf(sum);
                //从平方的尾部往前截取到与当前数长度相同的子串
                if(s2.substring(s2.length()-s1.length()).equals(s1)){
                    count++;
                }
            }
            System.out.println(count);
        }
    }
}
