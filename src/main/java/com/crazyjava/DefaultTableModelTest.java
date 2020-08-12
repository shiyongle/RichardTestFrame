package com.crazyjava;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import java.awt.*;
import java.util.ArrayList;

/**
 * @Author: Richered
 * @Date: 2020/08/07 12:32
 * @Description:
 **/
public class DefaultTableModelTest {

    JFrame mainWin = new JFrame("管理数据行、数据列");

    final int COLUMN_COUNT = 5;

    DefaultTableModel model;

    JTable table;

    ArrayList<TableColumn> hideColumns = new ArrayList<>();

    public void init(){

        model = new DefaultTableModel(COLUMN_COUNT, COLUMN_COUNT);

        for (int i = 0; i < COLUMN_COUNT; i ++){
            for (int j = 0; i < COLUMN_COUNT; j ++){
                model.setValueAt("老单元格值：" + i + " " + j , i, j);
            }
        }

        table = new JTable(model);

        mainWin.add(new JScrollPane(table), BorderLayout.CENTER);

        JMenuBar menuBar = new JMenuBar();

        mainWin.setJMenuBar(menuBar);

        JMenu tableMenu = new JMenu("管理");

        menuBar.add(tableMenu);

        JMenuItem hideColumnsItem = new JMenuItem("隐藏选中列");

        hideColumnsItem.addActionListener(event ->{

            int[] selected = table.getSelectedColumns();

            TableColumnModel columnModel = table.getColumnModel();

            for (int i = selected.length - 1 ; i >= 0; i -- ){

                TableColumn column = columnModel.getColumn(selected[i]);

                table.removeColumn(column);

                hideColumns.add(column);
            }
        });

        tableMenu.add(hideColumnsItem);

        JMenuItem showColumnsItem = new JMenuItem("显示隐藏列");

        showColumnsItem.addActionListener(event ->{

            for (TableColumn tc : hideColumns){

                table.addColumn(tc);

            }

            hideColumns.clear();
        });

        tableMenu.add(showColumnsItem);

        JMenuItem addColumnItem = new JMenuItem("插入选中列");

        addColumnItem.addActionListener(event ->{

            int[] selected = table.getSelectedColumns();

            TableColumnModel columnModel = table.getColumnModel();

            for (int i = selected.length - 1; i >= 0; i --){
                TableColumn column = columnModel.getColumn(i);
                table.addColumn(column);
            }
        });

        tableMenu.add(addColumnItem);

        JMenuItem addRowItem = new JMenuItem("增加行");

        addRowItem.addActionListener(event ->{
            String[] newCells = new String[COLUMN_COUNT];

            for (int i = 0; i < newCells.length; i ++){
                newCells[i] = "新单元格" + model.getRowCount() + " " + i;
            }

            model.addRow(newCells);
        });
        tableMenu.add(addRowItem);

        JMenuItem removeRowItem = new JMenuItem("删除选中行");

        removeRowItem.addActionListener(event -> {
            int[] selected = table.getSelectedRows();

            for (int i = selected.length - 1; i >= 0; i --){
                model.removeRow(selected[i]);
            }
        });

        tableMenu.add(removeRowItem);

        mainWin.pack();

        mainWin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        mainWin.setVisible(true);
    }

    public static void main(String[] args) {
        new DefaultListModelTest().init();
    }
}
