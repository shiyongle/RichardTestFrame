package com.crazyjava;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import javax.swing.undo.UndoableEdit;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.lang.annotation.Documented;
import java.lang.ref.Cleaner;
import java.util.LinkedList;

/**
 * @Author: Richered
 * @Date: 2020/08/09 21:48
 * @Description:
 **/
public class MonitorText {

    JFrame mainWin = new JFrame("监听Document对象");

    JTextArea target = new JTextArea(4, 35);

    JTextArea msg = new JTextArea(5, 35);

    JLabel label = new JLabel("文本域的修改信息");

    Document doc = target.getDocument();

    LinkedList<UndoableEdit> undoList = new LinkedList<>();

    final int UNDO_COUNT = 20;

    public void init(){

        msg.setEnabled(false);

        doc.addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                int offset = e.getOffset();
                int len = e.getLength();
                msg.append("插入文本的长度:" + len + "\n");
                msg.append("插入文本的起始位置：" + offset + "\n");
                try {
                    msg.append("插入文本内容：" + doc.getText(offset, len) + "\n");
                }catch (BadLocationException evt){
                    evt.printStackTrace();
                }
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                int offset = e.getOffset();
                int len = e.getLength();
                msg.append("删除文本的长度:" + len + "\n");
                msg.append("删除文本的起始位置:" + offset + "\n");
            }

            @Override
            public void changedUpdate(DocumentEvent e) {

            }
        });

        doc.addUndoableEditListener(e -> {
            UndoableEdit edit = e.getEdit();
            if (edit.canUndo() && undoList.size() < UNDO_COUNT){
                undoList.add(edit);
            }else if (edit.canUndo() && undoList.size() >= UNDO_COUNT){
                undoList.pop();
                undoList.add(edit);
            }
        });

        target.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                if (e.getKeyChar() == 26){
                    if (undoList.size() > 0){
                        undoList.removeLast().undo();
                    }
                }
            }
        });

        Box box = new Box(BoxLayout.Y_AXIS);
        box.add(new JScrollPane(target));
        JPanel panel = new JPanel();
        panel.add(label);
        box.add(panel);
        box.add(new JScrollPane(msg));
        mainWin.add(box);
        mainWin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainWin.pack();
        mainWin.setVisible(true);

    }

    public static void main(String[] args) {
        new MonitorText().init();
    }
}
