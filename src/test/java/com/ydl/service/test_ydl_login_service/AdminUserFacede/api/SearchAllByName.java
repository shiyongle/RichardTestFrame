package com.ydl.service.test_ydl_login_service.AdminUserFacede.api;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

/**
 * @Author: Richered
 * @Date: 2020/3/27 16:17
 * Description:
 */
public class SearchAllByName {
    public Response searchName(String name){
        return given()
                .queryParam("name", name)
                .contentType(ContentType.JSON)
                .when().log().all()
                .post("http://47.97.49.44:9092/h/com.ydl.login.intf.facade.AdminUserFacade/searchAllByName")
                .then().log().all()
                .body("code", equalTo("200"))
                .extract().response();
    }
}
