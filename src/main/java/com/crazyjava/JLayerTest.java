package com.crazyjava;

import javax.swing.*;
import javax.swing.plaf.LayerUI;
import java.awt.*;

/**
 * @Author: Richered
 * @Date: 2020/07/30 13:14
 * @Description:
 **/
public class JLayerTest {
    public void init(){
        JFrame f = new JFrame("JLayer测试");

        JPanel p = new JPanel();

        ButtonGroup group = new ButtonGroup();

        JRadioButton radioButton;

        p.add(radioButton = new JRadioButton("网购购买", true));

        group.add(radioButton);

        p.add(radioButton = new JRadioButton("书店购买"));

        group.add(radioButton);

        p.add(radioButton = new JRadioButton("图书馆借阅"));

        group.add(radioButton);

        p.add(new JCheckBox("疯狂java讲义"));
        p.add(new JCheckBox("疯狂android讲义"));
        p.add(new JCheckBox("疯狂ios讲义"));
        p.add(new JCheckBox("企业轻量级java ee实战"));

        JButton orderButton = new JButton("投票");

        p.add(orderButton);

        LayerUI<JComponent> layerUI = new FirstLayerUI();

        JLayer layer = new JLayer<>(p, layerUI);

        f.add(layer);

        f.setSize(300, 170);

        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        f.setVisible(true);
    }

    public static void main(String[] args) {
        new JLayerTest().init();
    }
}
