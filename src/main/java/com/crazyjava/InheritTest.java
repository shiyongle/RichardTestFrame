package com.crazyjava;

/**
 * @Author: Richered
 * @Date: 2020/6/16 14:00
 * Description:
 */
public class InheritTest {
    public static void main(String[] args) {
        Bird b = new Bird();
//        b.breathe();
        b.fly();

        Wolf w = new Wolf();
        w.breathe();
        w.run();
    }
}
