package com.service.department;

import io.restassured.http.ContentType;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

/**
 * @Author: Richered
 * @Date: 2020/1/3 22:08
 * @Description: 标签部分
 */
public class TestClassTag {

    static String token;

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
     * 创建标签
     * 此处需要考虑tagid是否存在，tagname是否存在
     */
    @Test
    public void addTag(){
        Map<String, Object> data = new HashMap<>();
        data.put("tagname","第一个标签");
        data.put("tagid",1);
        given()
                .queryParam("access_token", token)
                .contentType(ContentType.JSON)
                .body(data)
        .when()
                .log().all()
                .post("https://qyapi.weixin.qq.com/cgi-bin/tag/create")
        .then()
                .log().all()
                .body("errcode", equalTo(0));
    }

    /**
     * 更新标签名称
     * 此处需要考虑传入的tagid是否存在，更新之后的tagname是否存在
     */
    @Test
    public void updateTag(){
        Map<String, Object> data = new HashMap<>();
        data.put("tagid",1);
        data.put("tagname","第一个标签-修改之后");
        given()
                .queryParam("access_token", token)
                .contentType(ContentType.JSON)
                .body(data)
                .when()
                .log().all()
                .post("https://qyapi.weixin.qq.com/cgi-bin/tag/update")
                .then()
                .log().all()
                .body("errcode", equalTo(0));
    }

    /**
     * 删除标签
     * 此处需要判断该id是否存在
     */
    @Test
    public void deleteTag(){
        given()
                .queryParam("access_token", token)
                .queryParam("tagid", 2)
                .when()
                .log().all()
                .get("https://qyapi.weixin.qq.com/cgi-bin/tag/delete")
                .then()
                .log().all()
                .body("errcode", equalTo(0));
    }

    /**
     * 获取标签列表
     */
    @Test
    public void listTag(){
        given()
                .queryParam("access_token", token)
        .when()
                .log().all()
                .get("https://qyapi.weixin.qq.com/cgi-bin/tag/list")
        .then()
                .log().all()
                .body("errcode", equalTo(0));
    }

    /**
     * 获取标签成员列表
     */
    @Test
    public void listTagUser(){
        given()
                .queryParam("access_token", token)
                .queryParam("tagid", 1)
                .when()
                .log().all()
                .get("https://qyapi.weixin.qq.com/cgi-bin/tag/get")
                .then()
                .log().all()
                .body("errcode", equalTo(0));
    }
}
