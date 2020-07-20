package com.crazyjava;

import java.awt.*;

/**
 * @Author: Richered
 * @Date: 2020/7/20 23:21
 * @Description:
 */
public class FrameTest {
    public static void main(String[] args) {
        Frame f = new Frame("测试窗口");
        f.setBounds(30,30,250,200);
        f.setVisible(true);
    }
}
