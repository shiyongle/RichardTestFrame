package com.crazyjava;

import javax.swing.*;

/**
 * @Author: Richered
 * @Date: 2020/08/04 12:37
 * @Description:
 **/
public class SimpleTable {

    JFrame jf = new JFrame("简单表格");

    JTable table;

    Object[][] tableData = {
            new Object[]{"李清照", 29, "女"},
            new Object[]{"苏格拉底", 56, "男"},
            new Object[]{"李白", 35, "男"},
            new Object[]{"弄玉", 18, "女"},
            new Object[]{"虎头", 2, "女"}
    };

    Object[] columnTitle = {"姓名","性别", "年龄"};

    public void init(){
        table = new JTable(tableData, columnTitle);

        jf.add(new JScrollPane(table));

        jf.pack();

        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        jf.setVisible(true);
    }

    public static void main(String[] args) {
        new SimpleTable().init();
    }
}
