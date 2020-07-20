package com.crazyjava;

import java.awt.*;

import static java.awt.BorderLayout.*;

/**
 * @Author: Richered
 * @Date: 2020/7/20 23:31
 * @Description:
 */
public class BorderLayoutTest {
    public static void main(String[] args) {
        Frame f = new Frame("测试窗口");
        f.setLayout(new BorderLayout(30, 5));
        f.add(new Button("南"), SOUTH);
        f.add(new Button("北"), NORTH);

        Panel p = new Panel();
        p.add(new TextField(20));
        p.add(new Button("单击我"));
        f.add(new Button("东"), EAST);
        f.pack();
        f.setVisible(true);
    }
}
