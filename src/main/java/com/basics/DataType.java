package com.basics;

import ch.qos.logback.core.net.SyslogOutputStream;

import java.util.Date;
import java.util.Scanner;

public class DataType {
    static String greeting = "Richered";

    static String dog = "Hisky";

    public String getGreeting() {
        return greeting;
    }

    public static void main(String[] args) {
        String s = greeting.substring(1,2);
        //判断一个字符串既不是空串也不为null
        if (s != null && s.length() != 0){
            System.out.println(s);
        }
        System.out.println(dog.replace('H', 'Z'));
        System.out.println(dog.toLowerCase().trim());
        System.out.println(dog.toUpperCase().trim());

        StringBuilder builder = new StringBuilder();        // 构建空字符串构造器，调用append方法进行添加，可添加char，String
        builder.append('c');
        builder.append("ss");
        System.out.println(builder);

        String completeString = builder.toString();         //toString方法转为字符串
        System.out.println(completeString);

//        Scanner in = new Scanner(System.in);                //控制台输入输出，不同数据类型对应不同方法，例如nextLine、nextInt
//        String name = in.nextLine();
//        System.out.println(name);
        double x = 1000.0 / 3.0;
        System.out.printf("%8.2f", x);
        System.out.printf("%tc", new Date());
    }
}
