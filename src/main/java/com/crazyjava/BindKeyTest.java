package com.crazyjava;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.InputEvent;

/**
 * @Author: Richered
 * @Date: 2020/07/27 18:09
 * @Description:
 **/
public class BindKeyTest {
    JFrame jf = new JFrame("测试键盘绑定");
    JTextArea jta = new JTextArea(5, 30);
    JButton jb = new JButton("发送");
    JTextField jtf = new JTextField(15);

    public void init(){
        jf.add(jta);
        JPanel jp = new JPanel();
        jp.add(jtf);
        jp.add(jb);
        jf.add(jp, BorderLayout.SOUTH);

        Action sendMsg = new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jta.append(jtf.getText() + "\n");
                jtf.setText("");
            }
        };
        jb.addActionListener(sendMsg);
        jtf.getInputMap().put(KeyStroke.getKeyStroke('\n', InputEvent.CTRL_DOWN_MASK), "send");
        jtf.getActionMap().put("send", sendMsg);
        jf.pack();
        jf.setVisible(true);
    }

    public static void main(String[] args) {
        new BindKeyTest().init();
    }
}
