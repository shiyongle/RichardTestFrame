package com.basics;

import javax.swing.*;
import java.awt.*;

/**
 * 桌球项目
 */
public class BallGame extends JFrame {

    Image ball = Toolkit.getDefaultToolkit().getImage("获取图片的路径");
    Image desk = Toolkit.getDefaultToolkit().getImage("获取图片的路径");
    double x = 100; //小球的横坐标
    double y = 100; //小球的纵坐标
    Boolean right = true;

    //画窗口的项目
    public void paint(Graphics g){
        g.drawImage(desk, 0, 0, null);
        g.drawImage(ball, (int) x, (int) y, null);

        if(right){
            x = x + 10;
        }else {
            x = x - 10;
        }
        //如果x值大于856（桌子的长度）弹回
        //30是小球的直径，40是桌子边框的宽度
        if (x > 856 - 40 - 30){
            right = false;
        }
        //如果x的值小于0，则往右边走
        if (x < 40){
            right = true;
        }
    }

    //窗口加载
    void launchFrame(){
        setSize(856, 500);
        setLocation(50,50);

        //重画窗口，每秒画25次
        while (true){
            repaint();
            try{
                Thread.sleep(40);
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        BallGame game = new BallGame();
        game.launchFrame();
    }
}
