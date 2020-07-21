package com.crazyjava;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

/**
 * @Author: Richered
 * @Date: 2020/7/21 23:48
 * @Description:
 */
public class WindowListenerTest {
    private Frame f = new Frame("测试");
    private TextArea ta = new TextArea(6, 40);

    public void init(){
        f.addWindowListener(new MyListener());
        f.add(ta);
        f.pack();
        f.setVisible(true);
    }

    class MyListener implements WindowListener {

        public void windowClosed(WindowEvent e){
            ta.append("窗口被成功关闭! \n");
        }

        public void windowClosing(WindowEvent e){
            ta.append("用户关闭敞口 \n");
            System.exit(0);
        }

        @Override
        public void windowIconified(WindowEvent e) {
            ta.append("窗口被最小化 \n");
        }

        @Override
        public void windowDeiconified(WindowEvent e) {
            ta.append("窗口被恢复 \n");
        }

        @Override
        public void windowActivated(WindowEvent e) {
            ta.append("窗口被激活！\n");
        }

        @Override
        public void windowDeactivated(WindowEvent e) {
            ta.append("窗口失去焦点！\n");
        }

        @Override
        public void windowOpened(WindowEvent e) {
            ta.append("窗口被再次打开！\n");
        }
    }

    public static void main(String[] args) {
        new WindowListenerTest().init();
    }
}
