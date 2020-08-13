package com.crazyjava;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.Properties;

/**
 * @Author: Richered
 * @Date: 2020/8/13 23:08
 * @Description:
 */
public class PreparedStatementTest {

    private String driver;

    private String url;

    private String user;

    private String pass;

    public void initParam(String paramFile) throws Exception{
        Properties props = new Properties();
        props.load(new FileInputStream(paramFile));
        props.getProperty(driver);
        props.getProperty(url);
        props.getProperty(user);
        props.getProperty(pass);
        Class.forName(driver);
    }

    public void insertUseStatement() throws Exception{
        long start = System.currentTimeMillis();
        try(Connection conn = DriverManager.getConnection(url, user, pass); Statement stmt = conn.createStatement()){
            for (int i = 0; i < 100; i ++){
                stmt.executeUpdate("instert into student_table values (null , '姓名" + i +"', 1)");
            }
            System.out.println("使用statement费时:" + (System.currentTimeMillis() - start));
        }
    }

    public void insertUsePrepare() throws Exception{
        long start = System.currentTimeMillis();
        try(Connection conn = DriverManager.getConnection(url, user, pass); PreparedStatement pstmt = conn.prepareStatement
                ("instert into student_table values (null , ? ,1)")){
            for (int i = 0; i < 100; i++){
                pstmt.setString(1, "姓名" + i);
                pstmt.executeUpdate();
            }
            System.out.println("使用PreparedStatement费时:" + (System.currentTimeMillis() - start));
        }
    }

    public static void main(String[] args) throws Exception {
        PreparedStatementTest pt = new PreparedStatementTest();
        pt.initParam("mysql.ini");
        pt.insertUsePrepare();
        pt.insertUseStatement();
    }
}
