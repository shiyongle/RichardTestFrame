package com.crazyjava;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableColumn;

/**
 * @Author: Richered
 * @Date: 2020/08/09 21:20
 * @Description:
 **/
public class TableCellEditorTest {


    JFrame jf = new JFrame("使用单元格编辑器");

    JTable table;

    Object[][] tableDate = {
            new Object[]{"李清照", 29, "女", new ImageIcon("icon/3.gif"), true},
            new Object[]{"苏格拉底", 56, "男", new ImageIcon("icon/3.gif"), false},
            new Object[]{"李白", 35, "男", new ImageIcon("icon/3.gif"), true},
            new Object[]{"弄玉", 28, "女", new ImageIcon("icon/3.gif"), true},
            new Object[]{"虎头", 2, "男", new ImageIcon("icon/3.gif"), false}
    };

    String[] columnTitle = {"姓名", "年龄", "性别", "朱头像", "是否中国人"};


    public void init(){
        ExtendsTableModel model = new ExtendsTableModel(columnTitle, tableDate);

        table = new JTable(model);

        table.setRowSelectionAllowed(false);

        table.setRowHeight(40);

        table.setDefaultEditor(ImageIcon.class, new ImageCellEditor());

        TableColumn lastColumn = table.getColumnModel().getColumn(4);

        JComboBox<ImageIcon> editCombo = new JComboBox<>();

        for (int i = 1; i <=10; i ++){
            editCombo.addItem(new ImageIcon("icon/" + i + ".gif"));
        }

        lastColumn.setCellEditor(new DefaultCellEditor(editCombo));

        jf.add(new JScrollPane(table));

        jf.pack();

        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        jf.setVisible(true);
    }

    public static void main(String[] args) {
        new TableCellEditorTest().init();
    }

}
