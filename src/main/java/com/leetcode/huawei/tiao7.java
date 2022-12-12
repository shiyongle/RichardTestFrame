package com.leetcode.huawei;

import java.util.Scanner;

/**
 * 挑7
 */
public class tiao7 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int n = sc.nextInt();
            int sum=0;
            for(int i = 1;i<=n;i++){
                if(i%7==0){
                    sum++;
                }else{
                    String s = String.valueOf(i);
                    if(s.contains("7")){
                        sum++;
                    }
                }
            }
            System.out.println(sum);
        }
    }
}
