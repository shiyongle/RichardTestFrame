package com.crazyjava;

import java.io.FileInputStream;
import java.sql.*;
import java.util.Properties;

/**
 * @Author: Richered
 * @Date: 2020/08/18 20:49
 * @Description:
 **/
public class DatabaseMetaDataTest {

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

    public void info() throws Exception{

        Class.forName(driver);

        try(Connection conn = DriverManager.getConnection(url, user, pass)){
            DatabaseMetaData dbmd = conn.getMetaData();
            ResultSet rs = dbmd.getTableTypes();
            System.out.println("---MySql支持的表类型信息--");
            printResultSet(rs);
            rs = dbmd.getTables("select_test", null, "%", new String[]{"TABLE"});
            printResultSet(rs);
            System.out.println("---当前数据库里的数据表信息---");
            rs = dbmd.getPrimaryKeys("select_test", null,"student_table");
            printResultSet(rs);
            System.out.println("----student_table表的主键信息-------");
            rs = dbmd.getProcedures("select_test",null, "%");
            System.out.println("----当前数据库里的存储过程信息-------");
            printResultSet(rs);
            rs= dbmd.getCrossReference("select_test", null, "teacher_table", null, null, "student_table");
            System.out.println("teacher_table表和student_table表之间的外键约束");
            printResultSet(rs);
            rs = dbmd.getColumns("select_test", null, "select_table", "%");
            System.out.println("student_table表的全部数据列");
            printResultSet(rs);
        }
    }


    public void printResultSet(ResultSet rs) throws Exception{
        ResultSetMetaData rsmd = rs.getMetaData();
        for (int i = 0; i < rsmd.getColumnCount(); i++){
            System.out.println(rsmd.getColumnClassName(i + 1) + "\t");
        }
        System.out.println("\n");
        while (rs.next()){
            for (int i = 0; i < rsmd.getColumnCount(); i ++){
                System.out.println(rs.getString(i + 1) + "\t");
            }
            System.out.println("\n");
        }
    }

    public static void main(String[] args) throws Exception{
        DatabaseMetaDataTest dt = new DatabaseMetaDataTest();
        dt.initParam("mysql.ini");
        dt.info();
    }
}
