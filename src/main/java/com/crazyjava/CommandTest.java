package com.crazyjava;

/**
 * @Author: Richered
 * @Date: 2020/6/30 15:56
 * Description:
 */
public class CommandTest {
    public static void main(String[] args) {
        ProcessArray pa = new ProcessArray();
        int[] target = {3, -4, 6, 4};
        pa.process(target, new PrintCommand());
        System.out.println("--------------");
        pa.process(target, new SquareCommand());
    }
}
