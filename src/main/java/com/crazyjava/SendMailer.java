package com.crazyjava;

import java.awt.*;

/**
 * @Author: Richered
 * @Date: 2020/07/22 12:41
 * @Description:
 **/
public class SendMailer {
    private Frame f = new Frame("测试");
    private TextField tf = new TextField(40);
    private Button send = new Button("发送");

    public void init(){
        send.addActionListener(new MailerListener(tf));
        f.add(tf);
        f.add(send, BorderLayout.SOUTH);
        f.pack();
        f.setVisible(true);
    }

    public static void main(String[] args) {
        new SendMailer().init();
    }
}
