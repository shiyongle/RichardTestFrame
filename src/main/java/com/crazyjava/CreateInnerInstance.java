package com.crazyjava;

/**
 * @Author: Richered
 * @Date: 2020/7/1 10:56
 * Description:
 */
public class CreateInnerInstance {
    public static void main(String[] args) {
        Out.In in = new Out().new In("测试信息");

        //等价
        Out.In in1;
        Out out = new Out();
        in1 = out.new In("测试信息");
    }
}
