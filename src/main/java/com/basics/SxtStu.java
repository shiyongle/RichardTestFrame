package com.basics;

/**
 * @Author: Richered
 * @Date: 2020/5/11 21:29
 * @Description: 内存分析代码:(笔记)栈堆分析图在面试真经中的java-内存分析部分
 */
public class SxtStu {
    int id;
    String sname;
    int age;
    Computer comp;

    SxtStu(){}

    void study(){
        System.out.println("我在学习！使用电脑:" + comp.brand);
    }

    void play(){
        System.out.println("我在玩游戏");
    }

    public static void main(String[] args) {
        SxtStu stu = new SxtStu();
        stu.id = 1001;
        stu.sname = "高淇";
        stu.age = 18;

        Computer c1 = new Computer();
        c1.brand = "联想";

        stu.comp = c1;

        stu.play();
        stu.study();

        int [] arr = new int[10];
        for (int i : arr){
            System.out.println(i);
        }
    }
}
