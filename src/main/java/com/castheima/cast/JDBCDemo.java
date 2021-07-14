package com.castheima.cast;

import com.castheima.dto.Emp;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Author: Richered
 * @Date: 2021/7/14 23:00
 * @Description
 */
public class JDBCDemo {

    public List<Emp> findAll(){
        Statement statement = null;
        Connection conn = null;
        List<Emp> list = null;
        try {
//            Class.forName("com.mysql.jdbc.Driver");

            String sql = "select * from emp";
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db", "root", "111111");
            statement = conn.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()){
                int id = rs.getInt("id");
                String ename = rs.getString("ename");
                int job_id = rs.getInt("job_id");
                int mgr = rs.getInt("mgr");
                Date joindate = rs.getDate("joindate");
                double salary = rs.getDouble("salary");
                double bouns = rs.getDouble("bouns");
                int dept_id = rs.getInt("dept_id");
                Emp emp = new Emp();
                list = new ArrayList<Emp>();
                emp.setId(id);
                emp.setEname(ename);
                emp.setJob_id(job_id);
                emp.setMgr(mgr);
                emp.setJoindate(joindate);
                emp.setSalary(salary);
                emp.setBouns(bouns);
                emp.setDept_id(dept_id);
                list.add(emp);
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
        return list;
    }
}
