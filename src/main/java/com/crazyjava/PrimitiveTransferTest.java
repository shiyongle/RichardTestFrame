package com.crazyjava;

/**
 * @Author: Richered
 * @Date: 2020/6/10 23:23
 * @Description:
 */
public class PrimitiveTransferTest {
    public static void swap(int a, int b){
        int temp = a;
        a = b;
        b = temp;
        System.out.println("swap方法里，a的值为：" + a + ", b的值为: " + b);
    }

    public static void main(String[] args) {
        int a = 6;
        int b = 9;
        swap(a, b);
        System.out.println("交换之后，变量a的值为" + a + "， b的值为:" + b);
    }
}
