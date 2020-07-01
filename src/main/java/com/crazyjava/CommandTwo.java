package com.crazyjava;

/**
 * @Author: Richered
 * @Date: 2020/7/1 13:46
 * Description: lambda表达式
 */
public class CommandTwo {
    public static void main(String[] args) {
        ProcessArray pa = new ProcessArray();
        int[] array = {3,-4,6,4};

        //处理数组，具体处理行为取决于匿名内部类
        pa.process(array, (int element) -> {
            System.out.println("数组的平方是：" + element * element);
        });
    }
}
