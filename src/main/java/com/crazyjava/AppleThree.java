package com.crazyjava;

/**
 * @Author: Richered
 * @Date: 2020/7/19 23:27
 * @Description:
 */
public class AppleThree<T extends Number> {
    T size;

    AppleThree(){

    }

    AppleThree(T size){
        this.size = size;
    }

    public T getSize() {
        return size;
    }

    public void setSize(T size) {
        this.size = size;
    }
}
