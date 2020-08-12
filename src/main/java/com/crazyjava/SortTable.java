package com.crazyjava;

import com.google.common.collect.Table;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * @Author: Richered
 * @Date: 2020/08/09 20:18
 * @Description:
 **/
public class SortTable {

    JFrame jf = new JFrame("可按列排序的表格");

    Object[][] tableDate = {
            new Object[]{"李清照", 29, "女"},
            new Object[]{"苏格拉底", 56, "男"},
            new Object[]{"李白", 35, "男"},
            new Object[]{"弄玉", 28, "女"},
            new Object[]{"虎头", 2, "男"}
    };

    Object[] columnTitle = {"姓名", "年龄", "性别"};

    JTable table = new JTable(tableDate, columnTitle);

    SortableTableModel sorterModel = new SortableTableModel(table.getModel());

    public void init(){
        table.setModel(sorterModel);
        table.getTableHeader().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent event) {
                if (event.getClickCount() < 2){
                    return;
                }
                int tableColumn = table.columnAtPoint(event.getPoint());
                int modelColumn = table.convertColumnIndexToModel(tableColumn);
                sorterModel.sort(modelColumn);
            }
        });
        jf.add(new JScrollPane(table));
        jf.pack();
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setVisible(true);
    }

    public static void main(String[] args) {
        new SortTable().init();
    }


    class SortableTableModel extends AbstractTableModel {

        public TableModel model;

        public int sortColumn;

        public Row[] rows;

        public SortableTableModel(TableModel m){
            model = m;

            rows = new Row[model.getRowCount()];

            for (int i = 0; i < rows.length; i++){

                rows[i] = new Row(i);

            }
        }

        public SortableTableModel() {

        }

        public void sort(int c){
            sortColumn = c;

            java.util.Arrays.sort(rows);

            fireTableDataChanged();
        }

        public Object getValueAt(int r, int c){
            return model.getValueAt(rows[r].index, c);
        }

        public boolean isCellEditTable(int r, int c){
            return model.isCellEditable(rows[r].index, c);
        }

        public void setValueAt(Object aValue, int r, int c){
            model.setValueAt(aValue, rows[r].index, c);
        }

        public int getRowCount(){
            return model.getRowCount();
        }

        public int getColumnCount(){
            return model.getColumnCount();
        }

        public String getRowCount(int c){
            return model.getColumnName(c);
        }

        public Class getColumnClass(int c){
            return model.getColumnClass(c);
        }
    }

    private class Row extends SortableTableModel implements Comparable<Row>{

        public int index;

        public Row(int index){
            super();
            this.index = index;
        }

        @Override
        public int compareTo(Row other) {

            Object a = model.getValueAt(index, sortColumn);
            Object b = model.getValueAt(other.index, other.sortColumn);
//            if (a instanceof b){
//                return ((Comparable)a).compareTo(b);
//            }else {
//                return a.toString().compareTo(b.toString());

            return 0;
        }
    }
}
