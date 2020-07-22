package com.crazyjava;

import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * @Author: Richered
 * @Date: 2020/07/22 12:34
 * @Description:
 **/
public class WindowAdapterTest {
    private Frame f = new Frame("测试");
    private TextArea ta = new TextArea(6,40);

    public void init(){
        f.addWindowListener(new MyListener());
        f.add(ta);
        f.pack();
        f.setVisible(true);
    }
    class MyListener extends WindowAdapter{
        public void windowClosing(WindowEvent e){
            System.out.println("用户窗口关闭 \n");
            System.exit(0);
        }
    }

    public static void main(String[] args) {
        new WindowAdapterTest().init();
    }
}
