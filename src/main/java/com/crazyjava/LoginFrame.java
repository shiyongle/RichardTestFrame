package com.crazyjava;

import javax.swing.*;
import java.awt.*;
import java.io.FileInputStream;
import java.sql.*;
import java.util.Properties;

/**
 * @Author: Richered
 * @Date: 2020/8/13 23:44
 * @Description:
 */
public class LoginFrame {
    private final String PROP_FILE = "mysql.ini";

    private String driver;

    private String url;

    private String user;

    private String pass;

    private JFrame jf = new JFrame("登录");

    private JTextField userFiled = new JTextField(20);

    private JTextField passFiled = new JTextField(20);

    private JButton loginButton = new JButton("登录");

    public void init() throws Exception{
        Properties connProp = new Properties();
        connProp.load(new FileInputStream(PROP_FILE));
        driver = connProp.getProperty(driver);
        url = connProp.getProperty(url);
        user = connProp.getProperty(user);
        pass = connProp.getProperty(pass);
        Class.forName(driver);
        loginButton.addActionListener(e ->{
            if (validate(userFiled.getText(), passFiled.getText())){
                JOptionPane.showMessageDialog(jf, "登录成功");
            }else {
                JOptionPane.showMessageDialog(jf, "登录失败");
            }
        });

        jf.add(userFiled, BorderLayout.NORTH);
        jf.add(passFiled);
        jf.add(loginButton, BorderLayout.SOUTH);
        jf.pack();
        jf.setVisible(true);
    }

    public boolean validate(String userName, String userPass){
        try(Connection conn = DriverManager.getConnection(url, user, pass); PreparedStatement pstmt = conn.prepareStatement("select * from jdbc_test where jdbc_name = ? and jdbc_desc = ?")){
            pstmt.setString(1, userName);
            pstmt.setString(2, userPass);
            try(ResultSet rs = pstmt.executeQuery()){
                if (rs.next()){
                    return true;
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }

    public static void main(String[] args) throws Exception {
        new LoginFrame().init();
    }

}
