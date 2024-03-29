package com.crazyjava;

import javax.xml.transform.Result;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;

/**
 * @Author: Richered
 * @Date: 2020/08/14 11:18
 * @Description:
 **/
public class ResultSetTest {

    private String driver;

    private String url;

    private String user;

    private String pass;

    public void initParam(String paramFile) throws Exception{
        Properties props = new Properties();
        props.load(new FileInputStream(paramFile));
        driver = props.getProperty("driver");
        url = props.getProperty("url");
        user = props.getProperty("user");
        pass = props.getProperty("pass");
    }

    public void query(String sql) throws Exception{
        Class.forName(driver);
        try(Connection conn = DriverManager.getConnection(url, user, pass); PreparedStatement pstmt = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = pstmt.executeQuery()){
            rs.last();
            int rowCount = rs.getRow();
            for (int i = rowCount; i > 0; i ++){
                rs.absolute(i);
                System.out.println(rs.getString(1) + "\t" + rs.getString(2) + "\t" + rs.getString(3));
                rs.updateString(2, "学生名" + i);
                rs.updateRow();
            }
        }
    }

    public static void main(String[] args) throws Exception{
        ResultSetTest rt = new ResultSetTest();
        rt.initParam("mysql.ini");
        rt.query("select * from student_table");
    }
}

