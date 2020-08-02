package com.crazyjava;

import javax.swing.*;
import java.awt.*;

/**
 * @Author: Richered
 * @Date: 2020/08/02 18:11
 * @Description:
 **/
public class DefaultListModelTest {
    private JFrame mainWin = new JFrame("测试DefaultListModel");

    private JList<String> bookList;

    private DefaultListModel<String> bookModel = new DefaultListModel<>();

    private JTextField bookName = new JTextField(20);

    private JButton removeBn = new JButton("删除所选图书");

    private JButton addBn = new JButton("添加指定图书");

    public void init(){
        bookModel.addElement("疯狂java讲义");
        bookModel.addElement("轻量级java ee企业应用实战");
        bookModel.addElement("疯狂android讲义");
        bookModel.addElement("疯狂ajax讲义");
        bookModel.addElement("经典java ee企业应用实战");

        bookList = new JList<>(bookModel);

        bookList.setVisibleRowCount(4);

        bookList.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);

        addBn.addActionListener(evt ->{
            if (!bookName.getText().trim().equals("")){
                bookModel.addElement(bookName.getText());
            }
        });

        removeBn.addActionListener(evt ->{
            if (bookList.getSelectedIndex() >= 0){
                bookModel.removeElementAt(bookList.getSelectedIndex());
            }
        });

        JPanel p = new JPanel();

        p.add(bookName);

        p.add(addBn);

        p.add(removeBn);

        mainWin.add(new JScrollPane(bookList));

        mainWin.add(p, BorderLayout.SOUTH);

        mainWin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        mainWin.pack();

        mainWin.setVisible(true);
    }

    public static void main(String[] args) {
        new DefaultListModelTest().init();
    }
}
