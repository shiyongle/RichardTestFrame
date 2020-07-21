package com.crazyjava;

import javafx.scene.control.CheckBox;

import javax.swing.*;
import java.awt.*;

/**
 * @Author: Richered
 * @Date: 2020/7/21 23:08
 * @Description:
 */
public class CommonComponent {
    Frame f = new Frame("测试");

    Button ok = new Button("确认");

    CheckboxGroup cbg = new CheckboxGroup();

    Checkbox male = new Checkbox("男", cbg, true);

    Checkbox female = new Checkbox("女", cbg, false);

    Checkbox married = new Checkbox("是否已婚?", false);

    Choice colorChoose = new Choice();

    List colorList = new List(6, true);

    TextArea ta = new TextArea(5, 20);

    TextField name = new TextField(50);

    public void init(){
        colorChoose.add("红色");
        colorChoose.add("绿色");
        colorChoose.add("蓝色");
        colorList.add("红色");
        colorList.add("绿色");
        colorList.add("蓝色");

        Panel botton = new Panel();
        botton.add(name);
        botton.add(ok);

        f.add(botton, BorderLayout.SOUTH);

        Panel checkPanel = new Panel();
        checkPanel.add(colorChoose);
        checkPanel.add(male);
        checkPanel.add(female);
        checkPanel.add(married);

        Box topLeft = Box.createHorizontalBox();
        topLeft.add(ta);
        topLeft.add(checkPanel);

        Box top = Box.createVerticalBox();
        top.add(topLeft);
        top.add(colorList);

        f.add(top);
        f.pack();
        f.setVisible(true);
    }

    public static void main(String[] args) {
        new CommonComponent().init();
    }
}
