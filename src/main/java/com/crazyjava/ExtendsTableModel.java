package com.crazyjava;

import javax.swing.table.DefaultTableModel;

/**
 * @Author: Richered
 * @Date: 2020/08/09 20:59
 * @Description:
 **/
public class ExtendsTableModel extends DefaultTableModel {
    public ExtendsTableModel(String[] columnNames, Object[][] cells){
            super(cells, columnNames);
    }

    public Class getColumnClass(int c){
        return getValueAt(0, c).getClass();
    }
}
