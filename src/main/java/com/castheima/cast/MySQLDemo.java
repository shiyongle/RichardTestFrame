package com.castheima.cast;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @Author: Richered
 * @Date: 2021/7/12 0:28
 * @Description
 */
public class MySQLDemo {



    public static void main(String[] args) {
        Statement statement = null;
        Connection conn = null;
        try {
//            Class.forName("com.mysql.jdbc.Driver");

            String sql = "insert into account values(null, '王五', 3000)";
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db", "root", "111111");
            statement = conn.createStatement();
            int count = statement.executeUpdate(sql);
            System.out.println(count);
            if (count > 1){
                System.out.println("添加成功");
            }else {
                System.out.println("添加失败");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            if (statement != null){
                try {
                    statement.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }

            if (conn != null){
                try {
                    conn.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        }
    }
}
