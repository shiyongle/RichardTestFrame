package com.crazyjava;

import java.awt.*;
import java.awt.Canvas;
import java.util.Random;

/**
 * @Author: Richered
 * @Date: 2020/7/22 23:06
 * @Description:
 */
public class SimpleDraw {

    private final String RECT_SHAPE = "rect";

    private final String OVAL_SHAPE = "oval";

    private Frame f = new Frame("简单绘图");

    private Button rect = new Button("绘制矩形");

    private Button oval = new Button("绘制原型");

    private MyCanvas drawArea = new MyCanvas();

    private String shape = "";

    public void init(){
        Panel p = new Panel();
        rect.addActionListener(e -> {
            shape = RECT_SHAPE;
            drawArea.repaint();
        });

        oval.addActionListener(e ->{
            shape = OVAL_SHAPE;
            drawArea.repaint();
        });

        p.add(rect);
        p.add(oval);
        drawArea.setPreferredSize(new Dimension(250, 180));
        f.add(drawArea);
        f.add(p, BorderLayout.SOUTH);
        f.pack();
        f.setVisible(true);
    }

    class MyCanvas extends Canvas{
        @Override
        public void paint(Graphics g) {
            Random rand = new Random();
            if(shape.equals(RECT_SHAPE)){
                g.setColor(new Color(220, 100, 80));
                g.drawRect(rand.nextInt(200), rand.nextInt(120), 40, 60);
            }
            if (shape.equals(OVAL_SHAPE)){
                g.setColor(new Color(80, 100, 200));
                g.fillOval(rand.nextInt(200), rand.nextInt(120), 50, 40);
            }
        }
    }

    public static void main(String[] args) {
        new SimpleDraw().init();
    }
}
