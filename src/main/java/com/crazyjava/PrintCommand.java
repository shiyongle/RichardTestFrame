package com.crazyjava;

/**
 * @Author: Richered
 * @Date: 2020/6/30 15:59
 * Description:
 */
public class PrintCommand implements Command {
    @Override
    public void process(int element) {
        System.out.println("迭代输出目标数组的元素:" + element);
    }
}
