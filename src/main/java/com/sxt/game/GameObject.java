package com.sxt.game;

import java.awt.*;

/**
 * @Author: Richered
 * @Date: 2020/5/13 23:52
 * @Description:
 */
public class GameObject {
    Image img;
    double x, y;
    int speed;
    int width, height;

    public GameObject(Image img, double x, double y, int speed, int width, int height) {
        this.img = img;
        this.x = x;
        this.y = y;
        this.speed = speed;
        this.width = width;
        this.height = height;
    }

    public GameObject(Image img, double x, double y) {
        this.img = img;
        this.x = x;
        this.y = y;
    }

    public void drawSelf(Graphics g){
        g.drawImage(img, (int)x, (int)y, null);
    }

    public GameObject(){}

    /**
     * 返回物体所在的矩形，便于后续的碰撞检测
     * @return
     */
    public Rectangle getRect(){
        return new Rectangle((int) x, (int) y, width, height);
    }
}
