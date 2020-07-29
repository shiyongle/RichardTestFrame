package com.crazyjava;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.beans.PropertyVetoException;

/**
 * @Author: Richered
 * @Date: 2020/7/29 23:35
 * @Description:
 */
public class JInternalFrameTest {
    final int DESKTOP_WIDTH = 480;

    final int DESKTOP_HEIGHT = 360;

    final int FRAME_DISTANCE = 30;

    JFrame jf = new JFrame("MDI界面");

    private MyJDesktopPane  desktop = new MyJDesktopPane();

    private int nextFrameX;

    private int nextFrameY;

    private int width = DESKTOP_WIDTH / 2;

    private int height = DESKTOP_HEIGHT / 2;

    JMenu fileMenu = new JMenu("文件");

    JMenu windowMenu = new JMenu("窗口");

    Action newAction = new AbstractAction("新建", new ImageIcon("ico/new.png")) {
        @Override
        public void actionPerformed(ActionEvent event) {
            final JInternalFrame iframe = new JInternalFrame("新文档", true, true, true, true);
            iframe.add(new JScrollPane(new JTextArea(8, 40)));
            desktop.add(iframe);
            iframe.reshape(nextFrameX, nextFrameY, width, height);
            iframe.show();
            nextFrameX += FRAME_DISTANCE;
            nextFrameY += FRAME_DISTANCE;
            if (nextFrameX + width > desktop.getWidth()){
                nextFrameX = 0;
            }
            if (nextFrameY + height > desktop.getHeight()){
                nextFrameY = 0;
            }
        }
    };

    Action exitAction = new AbstractAction("退出", new ImageIcon("ico/exit.png")) {
        @Override
        public void actionPerformed(ActionEvent event) {
            System.exit(0);
        }
    };

    public void init(){
        JMenuBar menuBar = new JMenuBar();
        JToolBar toolBar = new JToolBar();
        jf.setJMenuBar(menuBar);
        menuBar.add(fileMenu);
        fileMenu.add(newAction);
        fileMenu.add(exitAction);
        toolBar.add(newAction);
        toolBar.add(exitAction);
        menuBar.add(windowMenu);
        JMenuItem nextItem = new JMenuItem("下一个");
        nextItem.addActionListener(event -> desktop.selectNextRow());
        windowMenu.add(nextItem);
        JMenuItem cascadeItem = new JMenuItem("级联");
        cascadeItem.addActionListener(event ->desktop.cascadeWindows(FRAME_DISTANCE, 0.75));
        windowMenu.add(cascadeItem);
        JMenuItem titleItem = new JMenuItem("平铺");
        titleItem.addActionListener(event -> desktop.titleWindows());
        windowMenu.add(titleItem);
        final JCheckBoxMenuItem dragOutlineItem = new JCheckBoxMenuItem("仅展示拖动窗口的轮廓");
        dragOutlineItem.addActionListener(event ->desktop.setDragMode(dragOutlineItem.isSelected()? JDesktopPane.OUTLINE_DRAG_MODE : JDesktopPane.LIVE_DRAG_MODE));
        windowMenu.add(dragOutlineItem);
        desktop.setPreferredSize(new Dimension(480, 360));
        jf.add(desktop);
        jf.pack();
        jf.setVisible(true);
    }

    public static void main(String[] args) {
        new JInternalFrameTest().init();
    }

    class MyJDesktopPane extends JDesktopPane{
        public void cascadeWindows(int offset, double scale){
            int width = (int)(getWidth() * scale);
            int height = (int)(getHeight() * scale);

            int x = 0;
            int y = 0;
            for (JInternalFrame frame: getAllFrames()){
                try{
                    frame.setMaximum(false);
                    frame.setIcon(false);
                    frame.reshape(x, y, width, height);
                    x += offset;
                    y += offset;
                    if (x + width > getWidth()){
                        x = 0;
                    }
                    if (y + height > getHeight()){
                        y = 0;
                    }
                }catch (PropertyVetoException e){}
            }
        }

        public void titleWindows(){
            int frameCount = 0;
            for (JInternalFrame frame : getAllFrames()){
                frameCount++;
            }
            int rows = (int)Math.sqrt(frameCount);
            int cols = frameCount / rows;
            int extra = frameCount % rows;
            int width = getWidth() / cols;
            int height = getHeight() / rows;
            int x = 0;
            int y = 0;
            for (JInternalFrame frame : getAllFrames()){
                try{
                    frame.setMaximum(false);
                    frame.setIcon(false);
                    frame.reshape(x * width, y * height, width, height);
                    y++;
                    if (y == rows){
                        y = 0;
                        x ++;
                        if (extra == cols -x){
                            rows++;
                            height = getHeight() / rows;
                        }
                    }
                }catch (PropertyVetoException e){}
            }
        }

        public void selectNextRow(){
            JInternalFrame[] frames = getAllFrames();
            for (int i = 0; i < frames.length; i ++){
                if (frames[i].isSelected()){
                    int next = (i + 1) % frames.length;
                    while (next != i){
                        if (!frames[next].isIcon()){
                            try{
                                frames[next].setSelected(true);
                                frames[next].toFront();
                                frames[i].toBack();
                                return;
                            }catch (PropertyVetoException e){}
                        }
                        next = (next + 1) % frames.length;
                    }
                }
            }
        }
    }
}
