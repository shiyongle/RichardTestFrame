package com.crazyjava;

/**
 * @Author: Richered
 * @Date: 2020/6/9 15:57
 * Description: iferror 示例
 */
public class IfErrorTest {
    public static void main(String[] args) {
        int age = 45;
        if (age > 60){
            System.out.println("老年人");
        }else if (age > 40){
            System.out.println("中年人");
        }else if (age > 20){
            System.out.println("青年人");
        }
    }
}
