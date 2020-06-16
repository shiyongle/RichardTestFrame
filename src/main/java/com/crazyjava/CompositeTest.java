package com.crazyjava;

/**
 * @Author: Richered
 * @Date: 2020/6/16 20:55
 * @Description:
 */
public class CompositeTest {
    public static void main(String[] args) {
        Animal a1 = new Animal();
        Bird b = new Bird(a1);
        b.breathe();
        b.fly();

        Animal a2 = new Animal();
        Wolf w = new Wolf(a2);
        w.breathe();
        w.run();
    }
}
