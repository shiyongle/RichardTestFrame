package com.crazyjava;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @Author: Richered
 * @Date: 2020/7/21 23:35
 * @Description:
 */
public class EventQs {
    private Frame f = new Frame("测试事件");
    private Button ok = new Button("确定");
    private TextField tf = new TextField(30);

    public void init(){
        ok.addActionListener(new OkListener());
        f.add(tf);
        f.add(ok, BorderLayout.SOUTH);
        f.pack();
        f.setVisible(true);
    }
    class OkListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("用户单击了ok按钮");
            tf.setText("HelloWorld");
        }
    }

    public static void main(String[] args) {
        new EventQs().init();
    }
}
