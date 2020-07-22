package com.crazyjava;

import java.awt.*;

/**
 * @Author: Richered
 * @Date: 2020/07/21 13:11
 * @Description:
 **/
public class BoxLayoutTest {
    private Frame f = new Frame("测试");
    public void init(){
        f.setLayout(new javax.swing.BoxLayout(f, javax.swing.BoxLayout.Y_AXIS));

        f.add(new Button("第一个按钮"));
        f.add(new Button("第二个按钮"));
        f.pack();
        f.setVisible(true);
    }

    public static void main(String[] args) {
        new BoxLayoutTest().init();
    }
}
