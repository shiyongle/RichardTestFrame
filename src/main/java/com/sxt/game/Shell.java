package com.sxt.game;

import java.awt.*;

import static java.lang.Math.PI;

/**
 * @Author: Richered
 * @Date: 2020/5/14 1:03
 * @Description: 炮弹类
 */
public class Shell extends GameObject{
    double degree;

    public Shell(){
      x = 200;
      y = 200;
      width = 10;
      height = 10;
      speed = 3;

      degree = Math.random() * PI *2;
    }

    public void draw(Graphics g){
        Color c = g.getColor();
        g.setColor(Color.YELLOW);

        g.fillOval((int) x, (int) y, width, height);

        /**炮弹沿着任意角度去飞**/
        x += speed *Math.cos(degree);
        y += speed *Math.sin(degree);

        /**碰壁反弹操作**/
        if (x < 0 || x > Constant.GAME_WIDTH - width){
            degree = PI - degree;
        }

        if (y < 30 || y > Constant.GAME_HEIGHT - height){
            degree = -degree;
        }

        g.setColor(c);
    }
}
