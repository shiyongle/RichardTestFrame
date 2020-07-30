package com.crazyjava;

import javax.swing.*;

/**
 * @Author: Richered
 * @Date: 2020/7/30 21:56
 * @Description:
 */
public class ProgressMonitorTest {
    Timer timer;

    public void init(){
        final JProgressBarTest2.SimulatedActivity target = new JProgressBarTest2.SimulatedActivity(1000);
        final Thread targetThread = new Thread(target);
        targetThread.start();
        final ProgressMonitor dialog = new ProgressMonitor(null, "等待任务完成", "已完成:", 0, target.getAmount());
        timer = new Timer(300, e ->{
            dialog.setProgress(target.getCurrent());
            if (dialog.isCanceled()){
                timer.stop();
                targetThread.interrupt();
                System.exit(0);
            }
        });
        timer.start();
    }

    public static void main(String[] args) {
        new ProgressMonitorTest().init();
    }
}
