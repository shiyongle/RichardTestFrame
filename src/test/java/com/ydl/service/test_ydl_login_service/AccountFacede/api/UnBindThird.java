package com.ydl.service.test_ydl_login_service.AccountFacede.api;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

/**
 * @Author: Richered
 * @Date: 2020/3/27 11:32
 * Description:
 */
public class UnBindThird {
    public Response GetUnBindThird(long uid){
        return given()
                .queryParam("uid", uid)
                .contentType(ContentType.JSON)
                .when()
                .log().all()
                .post("/h/com.ydl.login.intf.facade.AccountFacade/unBindThird")
                .then()
                .log().all()
                .body("code", equalTo("200"))
                .extract().response();
    }
}
