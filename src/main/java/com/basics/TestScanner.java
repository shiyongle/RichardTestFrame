package com.basics;

import java.util.Scanner;

/**
 * @Author: Richered
 * @Date: 2020/4/29 0:12
 * @Description:
 */
public class TestScanner {
    public static void main(String []args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入你的名字：");
        String name = scanner.nextLine();
        System.out.println("请输入你的爱好:");
        String favor = scanner.nextLine();
        System.out.println("请输入你的年龄：");
        int age = scanner.nextInt();

        System.out.println("*************");
        System.out.println(name);
        System.out.println(favor);
        System.out.println(age);

        System.out.println("*************");
        int yourage = (int) (100 * Math.random());
        System.out.println("年龄是:" + age + ", 属于：");
        if (yourage < 15){
            System.out.println("小孩");
        }else if (yourage < 25){
            System.out.println("青少年");
        }else if (yourage < 35){
            System.out.println("而立之年");
        }else if (yourage < 45){
            System.out.println("不惑之年");
        }else if (yourage < 55){
            System.out.println("知天命之年");
        }else {
            System.out.println("中老年");
        }

//        for (int i = 1; i <= 5; i++){
//            for (int j = 1; j <= 5; j++){
//                System.out.print(i + "\t");
//            }
//            System.out.println();
//        }
         for (int j = 1; j <= 9; j++){
             for (int i = 1; i <= j; i++){
                 System.out.print(i + "*" + j + "=" + i*j + "\t");
             }
             System.out.println();
         }
    }
}
