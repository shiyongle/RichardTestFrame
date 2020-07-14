package com.crazyjava;

import java.awt.*;

/**
 * @Author: Richered
 * @Date: 2020/7/14 21:50
 * @Description:
 */
public class Rectangle extends ShapeOne{
    @Override
    public void draw(Canvas c) {
        System.out.println("把一个矩形画在画布:" + c + "上");
    }
}
