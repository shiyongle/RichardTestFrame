package com.crazyjava;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

import static java.lang.Class.forName;

/**
 * @Author: Richered
 * @Date: 2020/08/05 12:15
 * @Description:
 **/
public class TableModelTest {

    JFrame jf = new JFrame("数据");

    private JScrollPane scrollPane;

    private ResultSetTableModel model;

    private JComboBox<String> tableNames = new JComboBox<>();

    private JTextArea changMsg = new JTextArea(4, 80);

    private ResultSet rs;

    private Connection conn;

    private Statement stmt;

    public void init(){
        tableNames.addItemListener(event->{
            try {
                if (scrollPane != null){
                    jf.remove(scrollPane);
                }
                String tableName = (String) tableNames.getSelectedItem();
                if (rs != null){
                    rs.close();
                }
                String query = "select * from " + tableName;

                rs = stmt.executeQuery(query);

                model = new ResultSetTableModel(rs);

                model.addTableModelListener(evt ->{
                    int row = evt.getFirstRow();
                    int column = evt.getColumn();
                    changMsg.append("修改的列:" + column + ",修改的行:" + row + "，修改后的值:" + model.getValueAt(row, column));
                });

                JTable table = new JTable(model);

                scrollPane = new JScrollPane(table);

                jf.add(scrollPane, BorderLayout.SOUTH);

                jf.validate();

            }catch (SQLException e){
                e.printStackTrace();
            }
        });

        JPanel  p = new JPanel();
        p.add(tableNames);
        jf.add(p, BorderLayout.NORTH);
        jf.add(new JScrollPane(changMsg), BorderLayout.SOUTH);

        try {
            conn = getConnection();

            DatabaseMetaData meta = conn.getMetaData();
            stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet tables = meta.getTables(null, null, null, new String[]{"TABLE"});
            while (tables.next()){
                tableNames.addItem(tables.getString(3));
            }
            tables.close();
        }catch (IOException e){
            e.printStackTrace();
        }catch (Exception e){
            e.printStackTrace();
        }
        jf.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent event) {
                try {
                    if (conn != null){
                        conn.close();
                    }
                }catch (SQLException e){
                    e.printStackTrace();
                }
            }
        });

        jf.pack();
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setVisible(true);
    }

    private static Connection getConnection() throws SQLException, IOException, ClassNotFoundException{
        Properties props = new Properties();
        FileInputStream in = new FileInputStream("conn.ini");
        props.load(in);
        in.close();
        String drivers = props.getProperty("jdbc.drivers");
        String url = props.getProperty("jdbc.url");
        String username = props.getProperty("jdbc.username");
        String password = props.getProperty("jdbc.password");
        Class.forName(drivers);
        return DriverManager.getConnection(url, username, password);
    }

    public static void main(String[] args) {
        new TableModelTest().init();
    }
}
