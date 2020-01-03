package com.service.department.testcase;

import com.service.department.api.Tag;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.equalTo;

/**
 * @Author: Richered
 * @Date: 2020/1/3 22:09
 * @Description: 标签用例
 */
public class TestTag {

    static Tag tag = new Tag();

    @BeforeAll
    public static void beforeAll(){

    }

    @Test
    public void add(){
        tag.addTag("第一个标签", 1).then().body("errcode", equalTo(0));
    }

    @Test
    public void update(){
        tag.updateTag(1,"case修改的name").then().body("errcode",equalTo(0));
    }

    @Test
    public void delete(){
        tag.deleteTag(1).then().body("errcode", equalTo(0));
    }

    @Test
    public void list(){
        tag.listTag().then().body("errcode", equalTo(0));
    }
}
