package com.crazyjava;

import javax.swing.*;
import java.awt.*;

/**
 * @Author: Richered
 * @Date: 2020/7/30 21:27
 * @Description:
 */
public class JProgressBarTest {
    JFrame frame = new JFrame("测试进度条");

    JProgressBar bar = new JProgressBar(JProgressBar.VERTICAL);

    JCheckBox indeterminate = new JCheckBox("不确定进度");

    JCheckBox noBorder = new JCheckBox("不绘制边框");

    public void init(){
        Box box = new Box(BoxLayout.Y_AXIS);
        box.add(indeterminate);
        box.add(noBorder);
        frame.setLayout(new FlowLayout());
        frame.add(box);
        frame.add(bar);
        bar.setMaximum(0);
        bar.setMaximum(100);
        bar.setStringPainted(true);
        noBorder.addActionListener(event-> bar.setBorderPainted(!noBorder.isSelected()));
        indeterminate.addActionListener(event-> {
            bar.setIndeterminate(indeterminate.isSelected());
            bar.setStringPainted(!indeterminate.isSelected());
        });
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        for (int i = 0; i <= 100; i++){
            bar.setValue(i);
            try {
                Thread.sleep(i);
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        new JProgressBarTest().init();
    }
}
