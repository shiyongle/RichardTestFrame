package com.crazyjava;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;

/**
 * @Author: Richered
 * @Date: 2020/7/23 23:23
 * @Description:
 */
public class CopyPerson {
    Frame f = new Frame("复制对象");
    Button copy = new Button("复制");
    Button paste = new Button("黏贴");
    TextField name = new TextField(15);
    TextField age = new TextField(15);
    TextArea ta = new TextArea(3, 30);

    Clipboard clipboard = new Clipboard("cp");

    public void init(){
        Panel p = new Panel();
        p.add(new Label("姓名"));
        p.add(name);
        p.add(new Label("年龄"));
        p.add(age);
        f.add(p, BorderLayout.NORTH);
        f.add(ta);
        Panel bp = new Panel();
        copy.addActionListener(e -> copyPerson());
        paste.addActionListener(e ->{
            try {
                readPerson();
            }catch (Exception ee){
                ee.printStackTrace();
            }
        });
        bp.add(copy);
        bp.add(paste);
        f.add(bp, BorderLayout.SOUTH);
        f.pack();
        f.setVisible(true);
    }

    public void copyPerson(){
        Person p = new Person(name.getText(), Integer.parseInt(age.getText()));
        LocalObjectSelection ls = new LocalObjectSelection(p);
        clipboard.setContents((Transferable) ls, null);
    }

    public void readPerson() throws Exception{
        DataFlavor personFlavor = new DataFlavor("application/x-java-jvm-local-objectref; class=Person");
        if (clipboard.isDataFlavorAvailable(DataFlavor.stringFlavor)){
            Person p = (Person)clipboard.getData(personFlavor);
            ta.setText(p.toString());
        }
    }

    public static void main(String[] args) {
        new CopyPerson().init();
    }
}
