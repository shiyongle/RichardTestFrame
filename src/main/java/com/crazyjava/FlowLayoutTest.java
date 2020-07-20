package com.crazyjava;

import java.awt.*;

/**
 * @Author: Richered
 * @Date: 2020/7/20 23:29
 * @Description:
 */
public class FlowLayoutTest {
    public static void main(String[] args) {
        Frame f = new Frame("测试窗口");
        f.setLayout(new FlowLayout(FlowLayout.LEFT, 20, 5));
        for (int i = 0; i < 10; i ++){
            f.add(new Button("按钮" + i));
        }

        f.pack();
        f.setVisible(true);
    }
}
