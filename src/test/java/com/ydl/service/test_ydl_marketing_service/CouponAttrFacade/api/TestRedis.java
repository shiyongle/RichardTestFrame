package com.ydl.service.test_ydl_marketing_service.CouponAttrFacade.api;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

/**
 * @Author: Richered
 * @Date: 2020/3/30 16:32
 * Description:
 */
public class TestRedis {
    public Response get(String test){
        return given()
                .queryParam("test", test)
                .contentType(ContentType.JSON)
                .when().log().all()
                .post("http://47.97.49.44:9099/h/com.ydl.marketing.intf.facade.CouponAttrFacade/testRedis")
                .then().log().all()
                .body("code", equalTo("200"))
                .extract().response();
    }
}
