package com.leetcode.huawei;

import java.util.Scanner;

/**
 * 将真分数分解为埃及分数
 */
public class TrueToFraction {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            String res = "";
            String[] arr = in.nextLine().split("/");
            String pre = "";
            int a = Integer.valueOf(arr[0]);
            int b = Integer.valueOf(arr[1]);
            while (true){
                int c = b/a+1;
                res += "1/";
                res += c;
                a = a - b % a;
                b = b * c;
                res += "+";
                if (a == 1){
                    res += "1/";
                    res += b;
                    break;
                }else if (a > 1 && b % a == 0){
                    res += "1/";
                    res += b/a;
                    break;
                }
            }
            System.out.println(res);
        }
    }
}
