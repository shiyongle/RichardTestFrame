package com.sxt.game;

import java.awt.*;
import java.awt.event.KeyEvent;

/**
 * @Author: Richered
 * @Date: 2020/5/14 0:08
 * @Description: 飞机
 */
public class Plan extends GameObject{

    boolean left, right, up, down;

    boolean live = true;

    public void drawSelf(Graphics g){
        if (live){
            g.drawImage(img, (int)x, (int)y, null);
            /**根据方向来控制飞机的移动方向**/
            if (left){
                x -= speed;
            }
            if(right){
                x += speed;
            }
            if (up){
                y -= speed;
            }
            if (down){
                y += speed;
            }
        }else {
            System.out.println("你已经挂了！CAME OVER!");
        }
    }

    public Plan(Image img, double x, double y) {
        this.img = img;
        this.x = x;
        this.y = y;
        this.speed = 3;
        this.width = img.getWidth(null);
        this.height = img.getHeight(null);
    }

    /**
     * 按下某个键，增加响应的方向
     * @param e
     */
    public void addDirection(KeyEvent e){
        switch (e.getKeyCode()){
            case KeyEvent.VK_LEFT:
                left = true;
                break;
            case KeyEvent.VK_UP:
                up = true;
                break;
            case KeyEvent.VK_RIGHT:
                right = true;
                break;
            case KeyEvent.VK_DOWN:
                down = true;
                break;
        }
    }

    /**
     * 按下某个键，取消响应的方向
     * @param e
     */
    public void minusDirection(KeyEvent e){
        switch (e.getKeyCode()){
            case KeyEvent.VK_LEFT:
                left = false;
                break;
            case KeyEvent.VK_UP:
                up = false;
                break;
            case KeyEvent.VK_RIGHT:
                right = false;
                break;
            case KeyEvent.VK_DOWN:
                down = false;
                break;
        }
    }
}
