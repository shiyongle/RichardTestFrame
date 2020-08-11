package com.crazyjava;

import javax.swing.*;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;
import java.awt.*;

/**
 * @Author: Richered
 * @Date: 2020/8/11 21:27
 * @Description:
 */
public class JTextPaneTest {
    JFrame mainWin = new JFrame("测试JTextPane");

    JTextPane txt = new JTextPane();

    StyledDocument doc = txt.getStyledDocument();

    SimpleAttributeSet android = new SimpleAttributeSet();

    SimpleAttributeSet java = new SimpleAttributeSet();

    SimpleAttributeSet javaee = new SimpleAttributeSet();

    public void init(){
        StyleConstants.setForeground(android, Color.RED);

        StyleConstants.setFontSize(android, 24);

        StyleConstants.setFontFamily(android,"Dialog");

        StyleConstants.setUnderline(android, true);

        StyleConstants.setForeground(java, Color.BLUE);

        StyleConstants.setFontSize(java, 30);

        StyleConstants.setFontFamily(java,"Arial Black");

        StyleConstants.setBold(java, true);

        StyleConstants.setForeground(javaee, Color.GREEN);

        StyleConstants.setFontSize(javaee, 32);

        StyleConstants.setItalic(javaee, true);

        txt.setEditable(false);

        txt.setText("疯狂android讲义\n" + "疯狂java讲义\n" + "轻量级java企业应用实战\n");

        doc.setCharacterAttributes(0, 12, android, true);

        doc.setCharacterAttributes(12, 12, java, true);

        doc.setCharacterAttributes(24, 30, javaee, true);

        mainWin.add(new JScrollPane(txt), BorderLayout.CENTER);

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

        int inset = 100;

        mainWin.setBounds(inset, inset, screenSize.width - inset * 2, screenSize.height - inset * 2);

        mainWin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        mainWin.setVisible(true);
    }

    public static void main(String[] args) {
        new JTextPaneTest().init();
    }
}
