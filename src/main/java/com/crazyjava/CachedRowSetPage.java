package com.crazyjava;

import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.RowSetFactory;
import javax.sql.rowset.RowSetProvider;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

/**
 * @Author: Richered
 * @Date: 2020/08/18 17:46
 * @Description:
 **/
public class CachedRowSetPage {

    private String driver;

    private String url;

    private String user;

    private String pass;

    public void initParam(String paramFile) throws Exception{

        Properties props = new Properties();

        driver = props.getProperty("driver");

        url = props.getProperty("url");

        user = props.getProperty("user");

        pass = props.getProperty("pass");
    }

    public CachedRowSet query(String sql, int pageSize, int page) throws Exception{

        Class.forName(driver);

        try(Connection conn = DriverManager.getConnection(url, user, pass);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql)){

            RowSetFactory factory = RowSetProvider.newFactory();

            CachedRowSet cachedRs = factory.createCachedRowSet();

            cachedRs.setPageSize(pageSize);

            cachedRs.populate(rs, (page - 1) * pageSize +1);

            return cachedRs;
        }
    }

    public static void main(String[] args) throws Exception{
        CachedRowSetPage cp = new CachedRowSetPage();

        cp.initParam("mysql.ini");

        CachedRowSet rs = cp.query("select * from student_table", 3, 2);

        while (rs.next()){
            System.out.println(rs.getString(1) + "\t" + rs.getString(2) + "\t" + rs.getString(3));
        }
    }
}
