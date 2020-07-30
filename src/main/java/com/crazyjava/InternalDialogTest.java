package com.crazyjava;

import javax.swing.*;
import java.awt.*;

/**
 * @Author: Richered
 * @Date: 2020/07/30 12:58
 * @Description:
 **/
public class InternalDialogTest {
    private JFrame jf = new JFrame("测试内部对话框");

    private JDesktopPane desktop = new JDesktopPane();

    private JButton internalBn = new JButton("内部窗口的对话框");

    private JButton deskBn = new JButton("虚拟桌面的对话框");

    private JInternalFrame iframe = new JInternalFrame("内部窗口");

    public void init(){
        iframe.add(new JScrollPane(new JTextArea(8, 40)));
        desktop.setPreferredSize(new Dimension(400, 300));
        jf.add(desktop);
        iframe.reshape(0, 0, 300, 200);
        iframe.show();
        desktop.add(iframe);

        JPanel jp = new JPanel();
        deskBn.addActionListener(event->JOptionPane.showInternalMessageDialog(desktop, "属于虚拟桌面的对话框"));
        internalBn.addActionListener(event -> JOptionPane.showInternalMessageDialog(iframe, "属于内部桌面的对话框"));
        jp.add(deskBn);
        jp.add(internalBn);
        jf.add(jp, BorderLayout.SOUTH);
        jf.pack();
        jf.setVisible(true);
    }

    public static void main(String[] args) {
        new InternalDialogTest().init();
    }
}
