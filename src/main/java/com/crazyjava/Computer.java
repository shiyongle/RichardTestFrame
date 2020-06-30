package com.crazyjava;

/**
 * @Author: Richered
 * @Date: 2020/6/30 15:32
 * Description:
 */
public class Computer {
    private Output out;

    public Computer(Output out){
        this.out = out;
    }

    /**
     * 定义一个模拟获取字符串输入的方法
     * @param msg
     */
    public void keyIn(String msg){
        out.getData(msg);
    }

    /**
     * 定义一个模拟打印的方法
     */
    public void print(){
        out.out();
    }
}
