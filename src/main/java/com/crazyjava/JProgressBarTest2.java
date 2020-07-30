package com.crazyjava;

import javax.swing.*;
import java.awt.*;
import java.sql.Time;

/**
 * @Author: Richered
 * @Date: 2020/7/30 21:35
 * @Description:
 */
public class JProgressBarTest2 {
    JFrame frame = new JFrame("测试进度条");

    JProgressBar bar = new JProgressBar(JProgressBar.VERTICAL);

    JCheckBox indeterminate = new JCheckBox("不确定进度");

    JCheckBox noBorder = new JCheckBox("不绘制边框");

    public void init(){
        Box  box = new Box(BoxLayout.Y_AXIS);
        box.add(indeterminate);
        box.add(noBorder);
        frame.setLayout(new FlowLayout());
        frame.add(box);
        frame.add(bar);
        bar.setStringPainted(true);
        noBorder.addActionListener(event -> bar.setBorderPainted(!noBorder.isSelected()));
        final SimulatedActivity target = new SimulatedActivity(1000);
        new Thread(target).start();
        bar.setMaximum(0);
        bar.setMaximum(target.getAmount());
        Timer timer = new Timer(300, e -> bar.setValue(target.getCurrent()));
        timer.start();
        indeterminate.addActionListener(event ->{
            bar.setIndeterminate(indeterminate.isSelected());
            bar.setIndeterminate(!indeterminate.isSelected());
        });
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new JProgressBarTest2().init();
    }

    static class SimulatedActivity implements Runnable{
        private volatile int current;

        private int amount;

        public SimulatedActivity(int amount){
            current = 0;
            this.amount = amount;
        }

        public int getAmount(){
            return amount;
        }

        public int getCurrent(){
            return current;
        }

        @Override
        public void run() {
            while (current < amount){
                try {
                    Thread.sleep(50);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
                current++;
            }
        }
    }
}
