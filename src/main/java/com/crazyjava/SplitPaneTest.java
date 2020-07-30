package com.crazyjava;

import com.google.gson.annotations.JsonAdapter;

import javax.swing.*;
import java.awt.*;
import java.awt.print.Book;

/**
 * @Author: Richered
 * @Date: 2020/07/28 13:25
 * @Description:
 **/
public class SplitPaneTest {
    Book[] books = new Book[]{
//            new Book("疯狂java讲义",new ImageIcon("ico/ java.png"), "国内关于java编程最全面的书\n看的懂, 学的会"),
//            new Book("轻量级Java EE企业引用实战", new ImageIcon("ico/ee.png"), "ssh整合"),
//            new Book("疯狂android讲义", new ImageIcon("ico/android.png"), "全面介绍anroid")
    };

    JFrame jf = new JFrame("测试SplitPane");
    JList<Book> bookList = new JList<>(books);
    JLabel bookCover = new JLabel();
    JTextArea bookDesc = new JTextArea();

    public void init(){
        bookList.setPreferredSize(new Dimension(150, 300));
        bookCover.setPreferredSize(new Dimension(300, 150));
        bookDesc.setPreferredSize(new Dimension(300, 150));

        bookList.addListSelectionListener(event -> {
            Book book = (Book)bookList.getSelectedValue();
//            bookCover.setIcon(book.getIco());
//            bookDesc.setText(book.getDesc());
        });

//        JSplitPane left = new JSplitPane(JSplitPane.VERTICAL_SPLIT, true, bookCover, new JSplitPane(bookDesc));
//        left.setOneTouchExpandable(true);
//        left.resetToPreferredSizes();

//        JSplitPane content = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, left, bookList);
//        jf.add(content);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.pack();
        jf.setVisible(true);
    }

    public static void main(String[] args) {
        new SplitPaneTest().init();
    }
}
