package com.castheima.cast;

import com.castheima.dto.Emp;
import com.castheima.utils.JDBCUtils;
import org.springframework.boot.autoconfigure.jdbc.JdbcTemplateAutoConfiguration;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @Author: Richered
 * @Date: 2021/7/15 0:29
 * @Description
 */
public class Templates {

    private JdbcTemplate jdbcTemplate = new JdbcTemplate(JDBCUtils.getDataSource());

    /**
     * 更改某条数据
     */
    public void test1(){
        JdbcTemplate jdbcTemplate = new JdbcTemplate(JDBCUtils.getDataSource());
        String sql = "update account set balance = 10000 where id = ?";
        int count = jdbcTemplate.update(sql, 1);
        System.out.println(count);
    }

    public void test2(){
        String sql = "insert into emp(id, ename, dept_id) values(?, ?, ?)";
        jdbcTemplate.update(sql, 101, "小二", 3);
    }

    public void test3(){
        String sql = "delete from emp where id = ?";
        jdbcTemplate.update(sql, 1);
    }

    /**
     * 查询一条记录，将其封装为map集合，列名为key，值作为value，封装为map，长度只能为1
     */
    public void test4(){
        String sql = "select * from emp where id = ?";
        Map<String, Object> stringObjectMap = jdbcTemplate.queryForMap(sql, 1);
        System.out.println(stringObjectMap);
    }

    /**
     * 将所有记录封装为list：将每一条记录封装为map，再将map装载到list集合中
     */
    public void test5(){
        String sql = "select * from emp";
        List<Map<String, Object>> list = jdbcTemplate.queryForList(sql);
        for (Map<String, Object> stringObjectMap : list){
            System.out.println(stringObjectMap);
        }
    }

    /**
     *查询所有记录，将其封装为Emp对象的list集合
     */
    public void test6(){
        String sql = "select * from emp";
        List<Emp> list = jdbcTemplate.query(sql, new RowMapper<Emp>() {
            @Override
            public Emp mapRow(ResultSet resultSet, int i) throws SQLException {
                Emp emp = new Emp();
                int id = resultSet.getInt("id");
                String ename = resultSet.getString("ename");
                int job_id = resultSet.getInt("job_id");
                int mgr = resultSet.getInt("mgr");
                Date joindate = resultSet.getDate("joindate");
                Double salary = resultSet.getDouble("salary");
                Double bonus = resultSet.getDouble("bonus");
                int dept_id = resultSet.getInt("dept_id");
                emp.setId(id);
                emp.setEname(ename);
                emp.setJob_id(job_id);
                emp.setMgr(mgr);
                emp.setJoindate(joindate);
                emp.setSalary(salary);
                emp.setBouns(bonus);
                emp.setDept_id(dept_id);
                return emp;
            }
        });

        for (Emp emp : list){
            System.out.println(emp);
        }
    }

    /**
     * 查询结果，将结果封装为javaBean对象
     */
    public void test6_2(){
        String sql = "select * from emp";
        List<Emp> list = jdbcTemplate.query(sql, new BeanPropertyRowMapper<Emp>(Emp.class));

        for (Emp emp : list){
            System.out.println(emp);
        }
    }

    /**
     * 查询总记录数
     */
    public void test7(){
        String sql = "select count(id) for emp";
        Long total = jdbcTemplate.queryForObject(sql, Long.class);
    }
}
