package com.crazyjava;

import javax.swing.*;
import java.awt.*;

/**
 * @Author: Richered
 * @Date: 2020/07/30 13:06
 * @Description:
 **/
public class SwingDndSupport {
    JFrame jf = new JFrame("swing的拖放支持");
    JTextArea srcText = new JTextArea(8, 30);
    JTextField jtf = new JTextField(34);

    public void init(){
        srcText.append("swing的拖放支持 \n");
        srcText.append("将该文本域的内容拖入其他程序 \n");

        srcText.setDragEnabled(true);
        jtf.setDragEnabled(true);

        jf.add(new JScrollPane(srcText));
        jf.add(jtf, BorderLayout.SOUTH);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.pack();
        jf.setVisible(true);
    }

    public static void main(String[] args) {
        new SwingDndSupport().init();
    }
}
