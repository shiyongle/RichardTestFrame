package com.ydl.service.cps_center_service.CpsCustomTestPriceFacade.api;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

/**
 * @Author: Richered
 * @Date: 2020/3/27 17:38
 * Description:
 */
public class ListByChannelId {
    public Response get(int channelId){
        return given()
                .queryParam("channelId", channelId)
                .contentType(ContentType.JSON)
                .when().log().all()
                .post("http://47.96.181.183:10088/h/com.ydl.wo.intf.facade.CpsCustomTestPriceFacade/listByChannelId")
                .then().log().all()
                .body("code", equalTo("200"))
                .extract().response();
    }
}
