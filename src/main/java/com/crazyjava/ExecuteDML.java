package com.crazyjava;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 * @Author: Richered
 * @Date: 2020/08/13 18:50
 * @Description:
 **/
public class ExecuteDML {
    private String driver;

    private String url;

    private String user;

    private String pass;

    public void initParam(String paramFile)throws Exception{
        Properties props = new Properties();
        props.load(new FileInputStream(paramFile));
        props.getProperty("driver");
        props.getProperty("url");
        props.getProperty("user");
        props.getProperty("pass");
    }

    public int insertDate(String sql) throws Exception{
        Class.forName(driver);
        try (
            Connection conn = DriverManager.getConnection(url, user, pass);
            Statement stmt = conn.createStatement();)
            {
                return stmt.executeUpdate(sql);
            }

    }

    public static void main(String[] args) throws Exception{
        ExecuteDML ed = new ExecuteDML();
        ed.initParam("mysql.ini");
        int result = ed.insertDate("inster into jdbc_test(jdbc_name, jdbc_desc) select s.student_name, t.teacher_name from student_table s, teacher_table t where s.java_teacher = t.teacher_id");
    }
}
