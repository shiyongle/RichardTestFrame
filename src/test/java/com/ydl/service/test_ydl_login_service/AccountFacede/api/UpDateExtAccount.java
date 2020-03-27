package com.ydl.service.test_ydl_login_service.AccountFacede.api;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

/**
 * @Author: Richered
 * @Date: 2020/3/27 11:35
 * Description: 更新账号扩展信息
 */
public class UpDateExtAccount {
    public Response GetUpDateExt(long uid, int hasGesture, int hasFingerprint){
        Map<String, Object> data = new HashMap<>();
        data.put("uid",uid);
        data.put("hasGesture",hasGesture);
        data.put("hasFingerprint", hasFingerprint);
        return given()
                .contentType(ContentType.JSON)
                .body(data)
                .when()
                .log().all()
                .post("http://47.97.49.44:9092/h/com.ydl.login.intf.facade.AccountFacade/updateExtAccount")
                .then()
                .log().all()
                .body("code", equalTo("300004"))
                .extract().response();
    }
}
