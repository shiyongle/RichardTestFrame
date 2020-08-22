package com.crazyjava;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @Author: Richered
 * @Date: 2020/08/22 18:43
 * @Description:
 **/
public class AnnotationTest {

    private JFrame mainWin = new JFrame("使用注释绑定事件监视器");

    @ActionListenerFor(listener = OkListener.class)
    private JButton ok = new JButton("确定");

    @ActionListenerFor(listener = CancelListenter.class)
    private JButton cancel = new JButton("取消");

    public void init(){
        JPanel jp = new JPanel();
        jp.add(ok);
        jp.add(cancel);
        mainWin.add(jp);
        ActionListenerInstaller.processAnnotations(this);
        mainWin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainWin.pack();
        mainWin.setVisible(true);
    }

    public static void main(String[] args) {
        new AnnotationTest().init();
    }



    class OkListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            JOptionPane.showMessageDialog(null, "单击了确认按钮");
        }
    }

    class CancelListenter implements  ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            JOptionPane.showMessageDialog(null, "单击了取消按钮");
        }
    }
}
