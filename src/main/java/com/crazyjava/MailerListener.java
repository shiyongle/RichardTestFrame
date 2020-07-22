package com.crazyjava;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @Author: Richered
 * @Date: 2020/07/22 12:38
 * @Description:
 **/
public class MailerListener implements ActionListener {

    private TextField mailAddress;
    public MailerListener(){}

    public MailerListener(TextField mailAddress){
        this.mailAddress = mailAddress;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("程序向" + mailAddress.getText() +"发送邮件...");
    }
}
