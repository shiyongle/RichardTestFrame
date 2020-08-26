package com.crazyjava;

/**
 * @Author: Richered
 * @Date: 2020/8/27 0:26
 * @Description:
 */
public class Orientation {
    public static final Orientation HORIZONTAL = new Orientation(1);
    public static final Orientation VERTIACL = new Orientation(2);
    private int value;

    private Orientation(int value){
        this.value = value;
    }
}
