package com.basics;

import javax.swing.*;
import java.awt.*;

/**
 * 桌球项目
 */
public class BallGameSecond extends JFrame {

    Image ball = Toolkit.getDefaultToolkit().getImage("获取图片的路径");
    Image desk = Toolkit.getDefaultToolkit().getImage("获取图片的路径");
    double x = 100; //小球的横坐标
    double y = 100; //小球的纵坐标

    double degree = 3.14/3; //弧度，此处为60度

    //画窗口的项目
    public void paint(Graphics g){
        g.drawImage(desk, 0, 0, null);
        g.drawImage(ball, (int) x, (int) y, null);

        x = x + 10 * Math.cos(degree);
        y = y + 10 * Math.sin(degree);

        //碰撞上下
        if (y > 500-40-30 || y < 40 + 40){  //最后一个40是标题栏的宽度
            degree = -degree;
        }

        //碰撞左右
        if (x < 40 || x > 856 -40 - 30){
            degree = 3.14 - degree;
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
        BallGameSecond game = new BallGameSecond();
        game.launchFrame();
    }
}
