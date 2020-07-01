package com.crazyjava;

/**
 * @Author: Richered
 * @Date: 2020/7/1 13:43
 * Description:
 */
public class CommandTestOne {
    public static void main(String[] args) {
        ProcessArray pa = new ProcessArray();
        int[] target = {3,-4,6,4};
        pa.process(target, new Command() {
            @Override
            public void process(int element) {
                System.out.println("数组的平方是：" + element * element);
            }
        });
    }
}
