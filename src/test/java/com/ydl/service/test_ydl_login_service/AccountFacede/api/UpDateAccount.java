package com.ydl.service.test_ydl_login_service.AccountFacede.api;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

/**
 * @Author: Richered
 * @Date: 2020/3/27 11:34
 * Description: 更改账号简单信息
 */
public class UpDateAccount {

    private String lastLoginTime = "2020-03-27T03:03:52.421Z";
    private String updateTime = "2020-03-27T03:03:52.421Z";


    public Response GetUpDate(long uid, String userName, String nickName, String email, String qq, String wechat, String remark, String lastLoginTime, String updateTime){
        Map<String, Object> data = new HashMap<>();
        data.put("uid",uid);
        data.put("userName",userName);
        data.put("nickName", nickName);
        data.put("email",email);
        data.put("qq",qq);
        data.put("wechat",wechat);
        data.put("remark",remark);
        data.put("lastLoginTime", lastLoginTime);
        data.put("updateTime", updateTime);
        return given()
                .contentType(ContentType.JSON)
                .body(data)
                .when()
                .log().all()
                .post("http://47.97.49.44:9092/h/com.ydl.login.intf.facade.AccountFacade/updateAccount")
                .then()
                .log().all()
                .body("code", equalTo("200"))
                .extract().response();
    }
}
