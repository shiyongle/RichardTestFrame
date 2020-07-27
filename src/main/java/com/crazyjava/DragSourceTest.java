package com.crazyjava;

import javax.swing.*;
import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.dnd.DnDConstants;
import java.awt.dnd.DragSource;

/**
 * @Author: Richered
 * @Date: 2020/07/24 13:06
 * @Description:
 **/
public class DragSourceTest {
    JFrame jf = new JFrame("Swing的拖放支持");

    JLabel srcLable = new JLabel("Swing的拖放支持.\n" + "将文本域的内容拖入其他程序.\n");

    public void init(){
        DragSource dragSource = DragSource.getDefaultDragSource();

        dragSource.createDefaultDragGestureRecognizer(srcLable,
                DnDConstants.ACTION_COPY_OR_MOVE,
                event -> {
                String txt = srcLable.getText();
                    StringSelection transferable = new StringSelection(txt);
                    event.startDrag(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR), transferable);
                });
        jf.add(new JScrollPane(srcLable));
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.pack();
        jf.setVisible(true);
    }

    public static void main(String[] args) {
        new DragSourceTest().init();
    }
}
