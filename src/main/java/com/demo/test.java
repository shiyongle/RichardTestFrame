package com.demo;

import java.util.Scanner;

public class test {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            int target = sc.nextInt();
            int y = 2;
            while (target != 1){
                if (target % y == 0){
                    System.out.println(y + " ");
                    target /= y;
                }else {
                    if (y >target /y){
                        target /= y;
                    }else {
                        y++;
                    }
                }
            }
        }
    }
}
