package com.crazyjava;

/**
 * @Author: Richered
 * @Date: 2020/6/30 16:00
 * Description:
 */
public class SquareCommand implements Command {
    @Override
    public void process(int element) {
        System.out.println("数组元素的平方是：" + element * element);
    }
}
