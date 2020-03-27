package com.ydl.service.test_ydl_login_service.AccountFacede.api;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

/**
 * @Author: Richered
 * @Date: 2020/3/27 11:24
 * Description: 修改密码
 */
public class ModifyPwd {

    public Response modify(long uid, String pwd){
        return given()
                .queryParam("uid", uid)
                .queryParam("newPwd", pwd)
                .contentType(ContentType.JSON)
                .when()
                .log().all()
                .post("http://47.97.49.44:9092/h/com.ydl.login.intf.facade.AccountFacade/modifyPwd")
                .then()
                .log().all()
                .body("code", equalTo("200"))
                .extract().response();
    }
}
