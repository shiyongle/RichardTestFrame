package com.crazyjava;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.util.List;
import java.util.Vector;

/**
 * @Author: Richered
 * @Date: 2020/07/31 12:59
 * @Description:
 **/
public class ListSwingTest {
    private JFrame mainWin = new JFrame("测试列表框");

    String[] books = new String[]{
            "疯狂java讲义",
            "轻量级java ee企业应用实战",
            "疯狂android讲义",
            "疯狂ajax讲义",
            "经典Java ee企业应用实战"
    };

    JList<String> bookList = new JList<>(books);

    JComboBox<String> bookSelector;

    JPanel layoutPanel = new JPanel();

    ButtonGroup layoutGroup = new ButtonGroup();

    JPanel selectModePanel = new JPanel();

    ButtonGroup selectModeGroup = new ButtonGroup();

    JTextArea favorite = new JTextArea(4, 40);

    public void init(){
        bookList.setVisibleRowCount(3);
        bookList.setSelectionInterval(2, 4);
        addLayoutButton("纵向滚动", JList.VERTICAL);
        addLayoutButton("纵向换行", JList.VERTICAL_WRAP);
        addLayoutButton("横向换行", JList.HORIZONTAL_WRAP);
        addSelectModelButton("无限制", ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        addSelectModelButton("单选", ListSelectionModel.SINGLE_SELECTION);
        addSelectModelButton("单范围", ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        Box listBox = new Box(BoxLayout.Y_AXIS);
        listBox.add(new JScrollPane(bookList));
        listBox.add(layoutPanel);
        listBox.add(selectModePanel);
        bookList.addListSelectionListener(e -> {
            List<String> books = bookList.getSelectedValuesList();
            favorite.setText("");
            for (String book : books){
                favorite.append(book + "\n");
            }
        });
        Vector<String> bookCollection = new Vector<>();
        bookCollection.add("疯狂java讲义");
        bookCollection.add("轻量级java ee企业应用实战");
        bookCollection.add("疯狂android讲义");
        bookCollection.add("疯狂ajax讲义");
        bookCollection.add("经典Java ee企业应用实战");
        bookSelector = new JComboBox<>(bookCollection);
        bookSelector.addItemListener(e -> {
            Object book = bookSelector.getSelectedItem();
            favorite.setText(book.toString());
        });
        bookSelector.setEditable(true);
        bookSelector.setMaximumRowCount(4);
        JPanel p = new JPanel();
        p.add(bookSelector);
        Box box = new Box(BoxLayout.X_AXIS);
        box.add(listBox);
        box.add(p);
        mainWin.add(box);
        JPanel favoritePanel = new JPanel();
        favoritePanel.setLayout(new BorderLayout());
        favoritePanel.add(new JScrollPane(favoritePanel));
        favoritePanel.add(new JLabel("您最喜欢的图书："), BorderLayout.NORTH);
        mainWin.add(favoritePanel, BorderLayout.SOUTH);
        mainWin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainWin.pack();
        mainWin.setVisible(true);
    }

    public void addLayoutButton(String label, final int orientation){
        layoutPanel.setBorder(new TitledBorder(new EtchedBorder()));
        JRadioButton button = new JRadioButton(label);
        layoutPanel.add(button);
        if (layoutGroup.getButtonCount() == 0){
            button.setSelected(true);
        }
        layoutGroup.add(button);
        button.addActionListener(event ->bookList.setLayoutOrientation(orientation));
    }


    private void addSelectModelButton(String label, final int selectModel){
        selectModePanel.setBorder(new TitledBorder(new EtchedBorder()));
        JRadioButton button = new JRadioButton(label);
        selectModePanel.add(button);
        if (selectModeGroup.getButtonCount() == 0){
            button.setSelected(true);
        }
        selectModeGroup.add(button);
        button.addActionListener(event ->bookList.setSelectionMode(selectModel));
    }

    public static void main(String[] args) {
        new ListSwingTest().init();
    }
}
