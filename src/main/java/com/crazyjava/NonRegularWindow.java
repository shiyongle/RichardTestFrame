package com.crazyjava;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.Ellipse2D;
import java.io.File;
import java.io.IOException;

/**
 * @Author: Richered
 * @Date: 2020/7/30 21:03
 * @Description:
 */
public class NonRegularWindow extends JFrame implements ActionListener {

    JFrame transWin = new JFrame("透明窗口");
    JFrame gradientWin = new JFrame("渐变透明窗口");
    JFrame bgWin = new JFrame("背景图片窗口");
    JFrame shapeWin = new JFrame("椭圆窗口");

    public NonRegularWindow(){
        super("不规则窗口");
        setLayout(new FlowLayout());
        JButton transBn = new JButton("透明窗口");
        JButton gradientBn = new JButton("渐变透明窗口");
        JButton shapeBn = new JButton("椭圆窗口");
        JButton BgBn = new JButton("背景图片窗口");

        transBn.addActionListener(this);
        gradientBn.addActionListener(this);
        shapeBn.addActionListener(this);
        BgBn.addActionListener(this);
        add(transBn);
        add(gradientBn);
        add(shapeBn);
        add(BgBn);
        transWin.setLayout(new GridBagLayout());
        transWin.setSize(300, 200);
        transWin.add(new JButton("透明窗口里的简单按钮"));
        transWin.setOpacity(0.65f);
        gradientWin.setBackground(new Color(0, 0, 0, 0));
        gradientWin.setSize(new Dimension(300, 200));
        JPanel panel = new JPanel(){
            protected  void paintComponent(Graphics g){
                if (g instanceof Graphics2D){
                    final int R = 240;
                    final int G = 240;
                    final int B = 240;
                    Paint p = new GradientPaint(0.0f, 0.0f, new Color(R, G, B, 0), 0.f,
                            getHeight(), new Color(R, G, B, 255));
                    Graphics2D g2d = (Graphics2D) g;
                    g2d.setPaint(p);
                    g2d.fillRect(0, 0, getWidth(), getHeight());
                }
            }
        };

        gradientWin.setContentPane(panel);
        panel.setLayout(new GridBagLayout());
        gradientWin.add(new JButton("渐变透明窗口里的简单按钮"));
        bgWin.setBackground(new Color(0, 0, 0, 0));
        bgWin.setSize(new Dimension(300, 200));
        JPanel bgPanel = new JPanel(){
            protected void paintComponent(Graphics g){
                try{
                    Image bg = ImageIO.read(new File("images/java.png"));
                    g.drawImage(bg, 0, 0, getWidth(), getHeight(), null);
                }catch (IOException ex){
                    ex.printStackTrace();
                }
            }
        };

        bgWin.setContentPane(bgPanel);
        bgPanel.setLayout(new GridBagLayout());
        bgWin.add(new JButton("有背景图片窗口里的简单按钮"));
        shapeWin.setLayout(new GridBagLayout());
        shapeWin.setUndecorated(true);
        shapeWin.setOpacity(0.7f);
        shapeWin.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                shapeWin.setShape(new Ellipse2D.Double(0, 0, shapeWin.getWidth(), shapeWin.getHeight()));
            }
        });
        shapeWin.setSize(300, 200);
        shapeWin.add(new JButton("椭圆形窗口里的简单按钮"));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        switch (event.getActionCommand()){
            case "透明窗口":
                transWin.setVisible(true);
                break;
            case "渐变透明窗口":
                gradientWin.setVisible(true);
                break;
            case "背景图片窗口":
                bgWin.setVisible(true);
                break;
            case "椭圆窗口":
                shapeWin.setVisible(true);
                break;
        }
    }

    public static void main(String[] args) {
        JFrame.setDefaultLookAndFeelDecorated(true);
        new NonRegularWindow();
    }
}
