package com.service;

import io.restassured.http.ContentType;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestTemplate;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

/**
 * @Author: Richered
 * @Date: 2020/1/2 22:45
 * @Description:接口测试第一节
 */
public class TestWord {

    static String token;
    static int parentDepartId = 2;      //父级部门id
    /**
     * Tencent 获取token
     */
    @BeforeAll
    public static void getToken(){
        token = given()
                .param("corpid","ww0fc4383ea8900ef8")
                .param("corpsecret","QJrWKfEXaaR72lhkwi5acMxtcDdaabylf-YyMwOAqeU")
        .when()
                .log().all()
                .get("https://qyapi.weixin.qq.com/cgi-bin/gettoken")
        .then()
                .log().all()
                .body("errcode", equalTo(0))
        .extract()
                .body().path("access_token");       //提取响应中的access_token

        System.out.println(token);
    }

    /**
     * Tencent 通讯录创建企业
     */
    @Test
    public void departCreate(){
        Map<String, Object> data = new HashMap<>();
        data.put("name","部门1");
        data.put("parentid",parentDepartId);


        given()
                .queryParam("access_token", token)
                .contentType(ContentType.JSON)
                .body(data)
        .when()
                .log().all()
                .post("https://qyapi.weixin.qq.com/cgi-bin/department/create")
        .then()
                .log().all()
                .body("errcode", equalTo(0));
    }
}
