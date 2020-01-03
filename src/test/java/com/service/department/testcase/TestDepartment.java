package com.service.department.testcase;

import com.service.department.api.Department;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.equalTo;

/**
 * @Author: Richered
 * @Date: 2020/1/3 12:32
 * Description: 部门部分--增删改查用例
 */
public class TestDepartment {

    static Department department = new Department();

    @BeforeAll
    public static void beforeAll(){

    }

    @Test
    public void list(){
        department.list(department.parentDepartId).then().body("errmsg", equalTo("ok"));
    }

    @Test
    public void create(){
        department.create("部门3").then().body("errmsg", equalTo("created"));
    }

    @Test
    public void delete(){

    }
}
