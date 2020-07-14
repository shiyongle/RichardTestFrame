package com.crazyjava;

import java.util.List;

/**
 * @Author: Richered
 * @Date: 2020/7/14 21:51
 * @Description:
 */
public class Canvas {
    //同时在画布上绘制多个形状，使用被限制的泛型通配符
    public void drawAll(List<? extends ShapeOne> shapeOnes){
        for (ShapeOne s : shapeOnes){
            s.draw(this);
        }
    }
}
