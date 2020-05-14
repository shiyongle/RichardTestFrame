package com.sxt.game;

import com.sun.imageio.plugins.common.ImageUtil;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Date;

/**
 * @Author: Richered
 * @Date: 2020/5/13 23:02
 * @Description: 游戏项目
 */
public class MyGameFrame extends Frame {

    Image planeImg = GameUtil.getImage("com/sxt/images/plane.png");

    Image bg  = GameUtil.getImage("com/sxt/images/bg.jpg");

    Plan plan = new Plan(planeImg, 250, 250);

    Shell[] shells = new Shell[50];

    private Image offScreenImage = null;

    Explode bao;

    Date startTime = new Date();

    Date endTime;

    int period;     //游戏持续时间


    /**
     * 初始化窗口
     */
    public void lunchFrame(){
        this.setTitle("My Project");
        this.setVisible(true);
        this.setSize(Constant.GAME_WIDTH, Constant.GAME_HEIGHT);
        this.setLocation(300, 300);
        this.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e){
                System.exit(0);
            }
        });
        new PaintThread().start();      //启动重画窗口的线程
        addKeyListener(new KeyMonitor());  //增加键盘的监听

        //初始化的时候生成50个炮弹
        for (int i = 0; i < shells.length; i++){
            shells[i] = new Shell();
        }
    }

    /**
     * 内部类，反复重画窗口
     */
    class PaintThread extends Thread{
        public void run(){
            while (true){
                System.out.println("窗口画一次！");
                repaint();      //重画
                try {
                    Thread.sleep(40);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }


    @Override
    public void paint(Graphics g) {
        Color c = g.getColor();
        g.drawImage(bg, 0, 0, null);
        plan.drawSelf(g);
        //画出50个炮弹
        for (int i = 0; i < shells.length; i++){
            shells[i].draw(g);
            //飞机和炮弹的碰撞检测
            boolean peng = shells[i].getRect().intersects(plan.getRect());
            if (peng){
                plan.live = false;
                if (bao == null){
                    bao = new Explode(plan.x, plan.y);
                    endTime = new Date();
                    period = (int)((endTime.getTime() - startTime.getTime())/1000);
                }
                bao.draw(g);
            }
            //计时功能，给出提示
            if (!plan.live){
                g.setColor(Color.red);
                Font f = new Font("宋体",Font.BOLD, 50);
                g.setFont(f);
                g.drawString("时间: " + period + "秒", (int) plan.x, (int) plan.y);
            }
        }
        g.setColor(c);
    }

    /**
     * 监听键盘的点击的内部类
     */
    class KeyMonitor extends KeyAdapter{
        @Override
        public void keyPressed(KeyEvent e) {
            plan.addDirection(e);
        }

        @Override
        public void keyReleased(KeyEvent e) {
            plan.minusDirection(e);
        }
    }

    public void update(Graphics g){
        if (offScreenImage == null){
            offScreenImage = this.createImage(Constant.GAME_WIDTH, Constant.GAME_HEIGHT);
        }
        Graphics gOff = offScreenImage.getGraphics();
        paint(gOff);
        g.drawImage(offScreenImage, 0, 0, null);
    }


    public static void main(String[] args) {
        MyGameFrame f = new MyGameFrame();
        f.lunchFrame();
    }
}
