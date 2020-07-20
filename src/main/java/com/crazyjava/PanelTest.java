package com.crazyjava;

import java.awt.*;

/**
 * @Author: Richered
 * @Date: 2020/7/20 23:23
 * @Description:
 */
public class PanelTest {
    public static void main(String[] args) {
        Frame f = new Frame("测试窗口");
        Panel p = new Panel();
        p.add(new TextField(20));
        p.add(new Button("单击我"));
        f.add(p);
        f.setBounds(30,30,250,200);
        f.setVisible(true);
    }
}
