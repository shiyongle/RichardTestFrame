package com.sxt.game;

import java.awt.*;

/**
 * @Author: Richered
 * @Date: 2020/5/14 1:37
 * @Description: 爆炸类
 */
public class Explode {
    double x, y;
    static Image[] imgs = new Image[16];
    static {
        for (int i = 0; i < 16; i++){
            imgs[i] = GameUtil.getImage("com/sxt/images/explode/e" + (i +1) + ".gif");
            imgs[i].getWidth(null);
        }
    }

    int count;

    public Explode(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public void draw(Graphics g){
        if (count <= 15){
            g.drawImage(imgs[count], (int) x, (int) y, null);
            count++;
        }
    }
}
