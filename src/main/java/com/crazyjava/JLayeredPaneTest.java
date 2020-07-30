package com.crazyjava;

import javax.swing.*;
import java.awt.*;

/**
 * @Author: Richered
 * @Date: 2020/07/29 19:01
 * @Description:
 **/
public class JLayeredPaneTest {
    JFrame jf = new JFrame("测试JLayeredPane");
    JLayeredPane layeredPane = new JLayeredPane();

    public void init(){
        layeredPane.add(new ContentPanel(10, 20, "疯狂java讲义", "ico/java.png"), JLayeredPane.MODAL_LAYER);
        layeredPane.add(new ContentPanel(100, 60, "疯狂Android讲义", "ico/android.png"), JLayeredPane.MODAL_LAYER);
        layeredPane.add(new ContentPanel(190, 100, "轻量级java ee企业应用实战", "ico/ee.png"), 4);

        layeredPane.setPreferredSize(new Dimension(400, 300));
        layeredPane.setVisible(true);
        jf.add(layeredPane);
        jf.pack();
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setVisible(true);
    }

    public static void main(String[] args) {
        new JLayeredPaneTest().init();
    }

    class ContentPanel extends JPanel{
        public ContentPanel(int xPos, int yPos, String title, String ico){
            setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), title));
            JLabel label = new JLabel(new ImageIcon(ico));
            add(label);
            setBounds(xPos, yPos, 160, 220);
        }
    }
}
