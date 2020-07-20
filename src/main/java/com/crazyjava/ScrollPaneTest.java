package com.crazyjava;

import java.awt.*;

/**
 * @Author: Richered
 * @Date: 2020/7/20 23:26
 * @Description:
 */
public class ScrollPaneTest {
    public static void main(String[] args) {
        Frame f = new Frame("测试窗口");
        ScrollPane sp = new ScrollPane(ScrollPane.SCROLLBARS_ALWAYS);

        sp.add(new TextField(20));
        sp.add(new Button("单击我"));

        f.add(sp);

        f.setBounds(30,30,200,250);
        f.setVisible(true);
    }
}
