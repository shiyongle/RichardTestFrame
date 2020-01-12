package com.service.user.testcase;

import com.github.mustachejava.DefaultMustacheFactory;
import com.github.mustachejava.Mustache;
import com.github.mustachejava.MustacheFactory;
import com.service.user.api.User;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.StringReader;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.not;

/**
 * @Author: Richered
 * @Date: 2020/1/10 16:59
 * @Description:
 */
public class TestUser {

    @Test
    public void info(){
        User user = new User();
        user.get("123456789").then().body("name", equalTo("Richared"));
    }

    @Test
    public void update(){
        User user = new User();
        String userid = "123456789";
        String nameNew = "name for testing";
        HashMap<String , Object> data = new HashMap<>();
        data.put("name", nameNew);
        data.put("address", "address for testing");
        user.update(userid, data);
        user.get(userid).then().body("name", equalTo(nameNew));
    }


    @Test
    public void create(){
        String nameNew = "name for testing" + System.currentTimeMillis();
        String userid = "Richered_" + System.currentTimeMillis();

        HashMap<String , Object> data = new HashMap<>();
        data.put("name", nameNew);
        data.put("department", new int[]{1});
        data.put("mobile", String.valueOf(System.currentTimeMillis()).substring(0,11));
        data.put("address", "address for testing");

        User user = new User();
        user.create(userid, data).then().body("errcode", equalTo(0));
        user.get(userid).then().body("name", equalTo(nameNew));
    }

    /**
     * 模板技术用例
     */
    @Test
    public void cloneUser(){
        String nameNew = "name for testing" + System.currentTimeMillis();
        String userid = "Richered_" + System.currentTimeMillis();

        HashMap<String , Object> data = new HashMap<>();
        data.put("name", nameNew);
//        data.put("department", new int[]{1});
        data.put("mobile", String.valueOf(System.currentTimeMillis()).substring(0,11));

        User user = new User();
        user.clone(userid, data).then().body("errcode", equalTo(0));
        user.get(userid).then().body("name", equalTo(nameNew));
    }

    /**
     * debug方法
     * 此处模板方法目的：根据user.json模板进行传参，只更改name、department、mobile参数
     * mustache的处理方式
     */
    @Test
    public void template() throws IOException {
        HashMap<String ,Object> data = new HashMap<String , Object>();
        data.put("name", "Mustache");
        data.put("mobile", String.valueOf(System.currentTimeMillis()).substring(0, 11));
        data.put("userid", System.currentTimeMillis());

        Writer writer = new OutputStreamWriter(System.out);
        MustacheFactory mf = new DefaultMustacheFactory();
        Mustache mustache = mf.compile(this.getClass().getResource("/com/service/user/api/user.json").getPath());
        mustache.execute(writer, data);
        writer.flush();
    }

    /**
     * 删除成员用例
     * 先创建【使用模板用例】，再进行删除
     */
    @Test
    public void delete(){
        String nameNew = "name for testing" + System.currentTimeMillis();
        String userid = "Richered_" + System.currentTimeMillis();

        HashMap<String , Object> data = new HashMap<>();
        data.put("name", nameNew);
//        data.put("department", new int[]{1});
        data.put("mobile", String.valueOf(System.currentTimeMillis()).substring(0,11));

        User user = new User();
        user.clone(userid, data).then().body("errcode", equalTo(0));

        user.delete(userid).then().body("errcode", equalTo(0));

        //再次获取userid，其状态码不等于0
        user.get(userid).then().body("errcode", not(equalTo(0)));
    }
}
