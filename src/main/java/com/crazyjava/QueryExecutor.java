package com.crazyjava;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.ExceptionListener;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.Properties;
import java.util.Vector;

/**
 * @Author: Richered
 * @Date: 2020/08/18 15:50
 * @Description:
 **/
public class QueryExecutor {
    JFrame jf = new JFrame("查询执行器");

    private JScrollPane scrollPane;

    private JButton execBn = new JButton("查询");

    private JTextField sqlField = new JTextField(45);

    private static Connection conn;

    private static Statement stmt;

    static {
        try{
            Properties props = new Properties();
            props.load(new FileInputStream("mysql.ini"));
            String driver = props.getProperty("driver");
            String url = props.getProperty("url");
            String user = props.getProperty("user");
            String pass = props.getProperty("pass");
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void init(){
        JPanel top = new JPanel();
        top.add(new JLabel("输入查询语句:"));
        top.add(sqlField);
        top.add(execBn);
        execBn.addActionListener(new ExceListener());
        sqlField.addActionListener(new ExceListener());
        jf.add(top, BorderLayout.NORTH);
        jf.setSize(680, 480);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setVisible(true);
    }

    class ExceListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent event) {
            if (scrollPane != null){
                jf.remove(scrollPane);
            }
            try(ResultSet rs = stmt.executeQuery(sqlField.getText())){
                ResultSetMetaData rsmd = rs.getMetaData();
                Vector<String> columnNames = new Vector<>();
                Vector<Vector<String>> data = new Vector<>();
                for (int i = 0; i < rsmd.getColumnCount(); i++){
                    columnNames.add(rsmd.getColumnName(i + 1));
                }
                while (rs.next()){
                    Vector<String> v = new Vector<>();
                    for (int i = 0; i < rsmd.getColumnCount(); i++){
                        v.add(rs.getString(i + 1));
                    }
                    data.add(v);
                }
                JTable table = new JTable(data, columnNames);
                scrollPane = new JScrollPane(table);
                jf.add(scrollPane);
                jf.validate();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }


    public static void main(String[] args) {
        new QueryExecutor().init();
    }
}
