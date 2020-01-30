package com.service.user.testcase;

import com.service.user.api.UserApi;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;

import static org.hamcrest.Matchers.equalTo;
import static io.restassured.module.jsv.JsonSchemaValidator.*;

/**
 * @Author: Richered
 * @Date: 2020/1/13 22:01
 * @Description: 测试数据驱动类
 */
public class TestUserApi {
    @Test
    public void get(){
        UserApi user = new UserApi();
        user.getUserInfo("123456789").then().body("errcode", equalTo(0));
    }

    @Test
    public void create(String userid, String name, String mobile, ArrayList<Integer> department, String age, String webUrl, String webTitle){
        HashMap<String, Object> body = new HashMap<>();
        body.put("userid", userid);
        body.put("name", name);
        body.put("mobile", mobile);
        body.put("department", department);
        body.put("age", age);
        body.put("webUrl", webUrl);
        body.put("webTitle", webTitle);

        UserApi user = new UserApi();
        user.createUser(body).then().body("errmsg",equalTo("created"));
    }

    /**断言读取json-schema断言文件
     * 如果判断某个字段可能为null，则需要在json_schema文件中进行处理，具体语法如下：
     * "anyOf":[
     *  {"type":"String"},
     *  {"type":"null"}
     * ]
     * **/
    @Test
    public void schema(){
        UserApi user = new UserApi();
        user.getUserInfo("123456789").then().body(matchesJsonSchemaInClasspath("com/service/user/testcase/user_get_schema_right.json"));
    }
}
