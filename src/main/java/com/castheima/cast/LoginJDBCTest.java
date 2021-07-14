package com.castheima.cast;

import com.castheima.utils.JDBCUtils;

import java.sql.*;
import java.util.Scanner;

/**
 * @Author: Richered
 * @Date: 2021/7/14 23:39
 * @Description
 */
public class LoginJDBCTest {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.println("请输入用户名：");
        String username = scn.nextLine();
        System.out.println("请输入密码:");
        String password = scn.nextLine();
        boolean flg = new LoginJDBCTest().login(username, password);
        if (flg){
            System.out.println("登录成功");
        }else {
            System.out.println("用户名或密码错误");
        }
    }



    Statement statement = null;
    Connection conn = null;
    PreparedStatement stmt = null;
    ResultSet rs = null;

    public boolean login(String username, String password){
        if (username == null || password == null){
            return false;
        }

        try {
            String sql = "select * from USER where username =? and password = ?";
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db", "root", "111111");
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, username);
            stmt.setString(2, password);
            rs = stmt.executeQuery();
            return rs.next();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
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

            if (stmt != null){
                try {
                    stmt.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        }
        return false;
    }
}
