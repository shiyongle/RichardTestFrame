package com.service.department.testcase;

import com.service.department.api.Department;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.Matchers.hasSize;

/**
 * @Author: Richered
 * @Date: 2020/1/3 12:32
 * Description: 部门部分--增删改查用例
 */
public class TestDepartment {

    static Department department = new Department();

    /**
     * 前置条件：清除历史数据
     * 此处获取全部的parentid
     * 将传入delete方法中的id在list中删除
     */
    @BeforeAll
    public static void beforeAll(){
        ArrayList<Integer> ids = department.list(department.parentDepartId).then()
                                .extract().body().path("department.findAll { d->d.parentid==" + department.parentDepartId + "}.id");
        System.out.println(ids);
        ids.forEach(id->department.delete(id));
    }

    @Test
    public void list(){
        department.list(department.parentDepartId).then().body("errmsg", equalTo("ok"));
    }

    @Test
    public void create(){
        String name = "部门3";
        department.create(name).then().body("errmsg", equalTo("created"));
        department.list(department.parentDepartId)
                .then().body("department.findAll { d->d.name== '" + name + "' }.id", hasSize(1));   //断言name
    }

    @Test
    public void delete(){
        int id = department.create("部门4").then().body("errmsg", equalTo("created"))
                .extract().body().path("id");
        System.out.println(id);
        department.delete(id).then().body("errmsg", equalTo("deleted"));
    }
}
