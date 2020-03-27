package com.ydl.service.test_ydl_login_service.AdminUserFacede.api;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

/**
 * @Author: Richered
 * @Date: 2020/3/27 15:37
 * Description: 获取管理员用户信息
 */
public class GetAdminUser {
    public Response get(int adminId){
        return given()
                .queryParam("adminId", adminId)
                .contentType(ContentType.JSON)
               .when().log().all()
                .post("http://47.97.49.44:9092/h/com.ydl.login.intf.facade.AdminUserFacade/getAdminUser")
               .then().log().all()
                .body("code", equalTo("200"))
                .extract().response();
    }
}
