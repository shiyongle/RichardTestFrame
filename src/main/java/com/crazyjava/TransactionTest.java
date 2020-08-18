package com.crazyjava;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Properties;

/**
 * @Author: Richered
 * @Date: 2020/08/18 20:38
 * @Description:
 **/
public class TransactionTest {

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

    public void insertTransaction(String[] sqls) throws Exception{

        Class.forName(driver);

        try(Connection conn = DriverManager.getConnection(url, user, pass)){
            conn.setAutoCommit(false);
            try(Statement stmt = conn.createStatement()){
                for (String sql : sqls){
//                    stmt.executeUpdate(sql);
                    stmt.addBatch(sql);
                }
            }
            conn.commit();
        }
    }


    public static void main(String[] args) throws Exception{
        TransactionTest tt = new TransactionTest();
        tt.initParam("mysql.ini");
        String[] sqls = new String[]{
                "insert into student_table value(null, 'a' , 1)",
                "insert into student_table value(null, 'b', 1)",
                "insert into student_table value(null, 'c', 1)",
                "insert into student_table value(null, 'c', 5)"
        };
        tt.insertTransaction(sqls);
    }
}
