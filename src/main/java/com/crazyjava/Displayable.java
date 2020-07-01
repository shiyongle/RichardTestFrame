package com.crazyjava;

/**
 * @Author: Richered
 * @Date: 2020/7/1 16:10
 * Description:
 */
public interface Displayable {
    void display();

    default int add(int a, int b){
        return a + b;
    }
}
