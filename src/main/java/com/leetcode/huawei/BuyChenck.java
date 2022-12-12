package com.leetcode.huawei;

import java.util.Scanner;

/**
 * 百钱买鸡问题
 */
public class BuyChenck {
    public static void main(String[] args)  {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNextInt()) {
            F(sc.nextInt());
        }
    }


    public static void F(int num) {
        int x,y,z,middle;
        for(x = 0; x<=14;x++){
            if((100 - 7*x) % 4 == 0){
                y = (100 - 7*x) / 4;
                z = 100-x-y;
                System.out.print(x +" ");
                System.out.print(y +" ");
                System.out.print(z +" ");
                System.out.println();
            }
        }
    }
}
