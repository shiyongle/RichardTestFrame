package com.leetcode.huawei;

import java.util.Scanner;

/**
 * 汽水瓶
 */
public class KoLe {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNextInt()){
            int bottle = sc.nextInt();
            if(bottle==0){
                break;
            }
            System.out.println(bottle/2);
        }
    }
}
