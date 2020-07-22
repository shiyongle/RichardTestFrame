package com.crazyjava;

import javax.swing.*;
import java.awt.*;

/**
 * @Author: Richered
 * @Date: 2020/07/21 13:19
 * @Description:
 **/
public class BoxSpaceTest {
    private Frame f = new Frame("测试");
    private Box horizontal = Box.createHorizontalBox();
    private Box vertical = Box.createVerticalBox();

    public void init(){
        horizontal.add(new Button("水平按钮一"));
        horizontal.add(Box.createHorizontalGlue());
        horizontal.add(new Button("水平按钮er"));

        horizontal.add(Box.createHorizontalStrut(10));
        horizontal.add(new Button("水平按钮三"));

        vertical.add(new Button("垂直按钮一"));
        vertical.add(Box.createHorizontalGlue());

        vertical.add(new Button("垂直按钮二"));
        vertical.add(Box.createHorizontalStrut(10));
        vertical.add(new Button("垂直按钮三"));
        f.add(horizontal, BorderLayout.NORTH);
        f.add(vertical);
        f.pack();
        f.setVisible(true);
    }

    public static void main(String[] args) {
        new BoxSpaceTest().init();
    }
}
