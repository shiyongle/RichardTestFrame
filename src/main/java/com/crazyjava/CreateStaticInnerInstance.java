package com.crazyjava;

/**
 * @Author: Richered
 * @Date: 2020/7/1 11:27
 * Description:
 */
public class CreateStaticInnerInstance {
    public static void main(String[] args) {
        StaticOut.StaticIn in = new StaticOut.StaticIn();

        //等价
        StaticOut.StaticIn in1;
        in1 = new StaticOut.StaticIn();
    }
}
