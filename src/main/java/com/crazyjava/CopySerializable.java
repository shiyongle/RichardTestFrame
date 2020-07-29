package com.crazyjava;

import com.google.gson.internal.$Gson$Preconditions;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.io.Serializable;

/**
 * @Author: Richered
 * @Date: 2020/7/23 23:49
 * @Description:
 */
public class CopySerializable {
    Frame f = new Frame("复制对象");
    Button copy = new Button("复制");
    Button paste = new Button("粘贴");
    TextField name = new TextField(15);
    TextField age = new TextField(15);
    TextArea ta = new TextArea(3, 30);

    Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();

    public void init(){
        Panel p = new Panel();
        p.add(new Label("姓名"));
        p.add(name);
        p.add(new Label("年龄"));
        p.add(age);
        f.add(p, BorderLayout.NORTH);
        f.add(ta);
        Panel bp = new Panel();
        copy.addActionListener(e -> copyDog());
        paste.addActionListener(e ->{
            try {
                readDog();
            }catch (Exception ee){
                ee.printStackTrace();
            }
        });
        bp.add(copy);
        bp.add(paste);
        bp.add(bp, BorderLayout.SOUTH);
        f.pack();
        f.setVisible(true);
    }

    public void copyDog(){
        Dog d = new Dog(Integer.parseInt(age.getText()), name.getText());
        SerialSelection ls = new SerialSelection((Serializable) d);
        clipboard.setContents((Transferable) ls, null);
    }

    public void readDog() throws Exception{
        DataFlavor personFlavor = new DataFlavor(DataFlavor.javaSerializedObjectMimeType + ";class=Dog");
        if (clipboard.isDataFlavorAvailable(DataFlavor.stringFlavor)){
            Dog d = (Dog)clipboard.getData(personFlavor);
            ta.setText(d.toString());
        }
    }

    public static void main(String[] args) {
        new CopySerializable().init();
    }
}
