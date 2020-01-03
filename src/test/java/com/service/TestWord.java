package com.service;

import io.restassured.http.ContentType;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

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
     * TODO:创建部门首先要去判断创建的该部门是否在原数据列表是否存在，避免有冗余数据；需要调用list接口校验，但如果编写list请求，会导致代码冗余带来维护问题，所以引入PO思想
     */
    @Test
    public void departCreate(){
        Map<String, Object> data = new HashMap<>();
        data.put("name","石永乐");
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

    /**
     * Tencent 通讯录获取部门列表
     */
    @Test
    public void departLis(){
        given()
                .queryParam("access_token", token)
                .queryParam("id", parentDepartId)
        .when()
                .get("https://qyapi.weixin.qq.com/cgi-bin/department/list")
        .then()
                .log().all()
                .body("errcode", equalTo(0));
    }
}
