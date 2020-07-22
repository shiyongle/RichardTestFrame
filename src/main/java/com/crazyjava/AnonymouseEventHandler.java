package com.crazyjava;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * @Author: Richered
 * @Date: 2020/07/22 12:48
 * @Description:
 **/
public class AnonymouseEventHandler {
    private Frame f = new Frame("测试");
    private TextArea ta = new TextArea(6, 40);

    public void init(){
        f.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.out.println("用户窗口关闭");
                System.exit(0);
            }
        });

        f.add(ta);
        f.pack();
        f.setVisible(true);
    }

    public static void main(String[] args) {
        new AnonymouseEventHandler().init();
    }
}
