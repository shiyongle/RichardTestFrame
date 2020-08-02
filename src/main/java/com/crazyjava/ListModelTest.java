package com.crazyjava;

import javax.swing.*;
import java.awt.*;
import java.math.BigDecimal;
import java.util.AbstractList;
import java.util.List;

/**
 * @Author: Richered
 * @Date: 2020/08/02 17:51
 * @Description:
 **/
public class ListModelTest {
    private JFrame mainWin = new JFrame("测试ListModel");

    private JList<BigDecimal> numScopeList = new JList<>(new NumberListModel(1, 21, 2));

    private JComboBox<BigDecimal> numScopeSelector = new JComboBox<>(new NumberComboBoxModel(0.1, 1.2, 0.1));

    private JTextField showVal = new JTextField(10);

    public void init(){
        numScopeList.setVisibleRowCount(4);

        numScopeList.setSelectionInterval(2, 4);

        numScopeList.setFixedCellHeight(30);

        numScopeList.setFixedCellWidth(90);

        numScopeList.addListSelectionListener(e -> {
            List<BigDecimal> nums = numScopeList.getSelectedValuesList();
            showVal.setText("");
            for (BigDecimal num : nums){
                showVal.setText(showVal.getText() + num.toString() + ",");
            }
        });

        numScopeSelector.setMaximumRowCount(5);

        Box box = new Box(BoxLayout.X_AXIS);

        box.add(new JScrollPane(numScopeList));

        JPanel p = new JPanel();

        p.add(numScopeSelector);

        box.add(p);

        numScopeSelector.addItemListener(e ->{
            Object num = numScopeSelector.getSelectedItem();
            showVal.setText(num.toString());
        });

        JPanel bottom = new JPanel();

        bottom.add(new JLabel("您选择的是："));

        bottom.add(showVal);

        mainWin.add(box);

        mainWin.add(bottom, BorderLayout.SOUTH);

        mainWin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        mainWin.pack();

        mainWin.setVisible(true);
    }

    public static void main(String[] args) {
        new ListModelTest().init();
    }
}
