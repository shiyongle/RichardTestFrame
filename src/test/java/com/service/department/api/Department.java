package com.service.department.api;

import com.service.Work;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

/**
 * @Author: Richered
 * @Date: 2020/1/3 12:35
 * Description: 部门部分interface
 */
public class Department {

    public int parentDepartId = 2;

    /**
     * 获取部门列表
     * @param id
     * @return
     */
    public Response list(int id){
        return given()
                .queryParam("access_token", Work.getInstance().getToken())
                .queryParam("id", this.parentDepartId)
        .when()
                .get("https://qyapi.weixin.qq.com/cgi-bin/department/list")
        .then()
                .log().all()
                .body("errcode", equalTo(0))
                .extract().response();
    }

    /**
     * 创建部门
     * @param name
     * @param parentid
     * @return
     */
    public Response create(String name, int parentid){
        Map<String, Object> data = new HashMap<>();
        data.put("name",name);
        data.put("parentid",parentid);


        return given()
                        .queryParam("access_token", Work.getInstance().getToken())
                        .contentType(ContentType.JSON)
                        .body(data)
                .when()
                        .log().all()
                        .post("https://qyapi.weixin.qq.com/cgi-bin/department/create")
                .then()
                        .log().all()
                        .body("errcode", equalTo(0))
                        .extract().response();
    }

    /**
     * 重载create方法
     * @param name
     * @return
     */
    public Response create(String name){
        return create(name, parentDepartId);
    }

    /**
     * 删除操作
     * @param id
     * @return
     */
    public Response delete(int id){
        return given()
                .queryParam("access_token", Work.getInstance().getToken())
                .queryParam("id", id)
        .when().log().all()
                .get("https://qyapi.weixin.qq.com/cgi-bin/department/delete")
        .then().log().all()
                .body("errcode", equalTo(0))
        .extract().response();
    }
}
