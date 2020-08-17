package com.crazyjava;

import java.sql.*;

/**
 * @Author: Richered
 * @Date: 2020/08/12 19:38
 * @Description:
 **/
public class ConnMysql {

    public static void main(String[] args) throws Exception{
        Class.forName("com.mysql.cj.jdbc.Driver");
        try{
            Connection conn = DriverManager.getConnection("jdbc:xxxxx");
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("select s.* , teacher_name from student_table s, teacher_table t where t.teacher_id = s.java_teacher");
            while (rs.next()){
                System.out.println(rs.getInt(1) + "\t" + rs.getString(2) + "\t" + rs.getString(4));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
