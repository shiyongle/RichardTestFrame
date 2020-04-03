package com.ydl.service.cps_center_service.CpsOrderSnapFacade.api;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

/**
 * @Author: Richered
 * @Date: 2020/3/30 13:53
 * Description:
 */
public class GetCpsOrderByChannel {
//    {
//        "distributorId": 112,
//            "orderType": 107,
//            "startTime": "2020-03-30T05:55:05.202Z",
//            "endTime": "2020-03-30T05:55:05.203Z",
//            "orderStartTime": "2020-03-30T05:55:05.203Z",
//            "orderEndTime": "2020-03-30T05:55:05.203Z",
//            "channelId": 107,
//            "customName": "string",
//            "channelIds": [
//        107
//  ]
//    }
    public Response get(){
        return given()
                .contentType(ContentType.JSON)
                .when().log().all()
                .post("http://47.96.181.183:10088/h/com.ydl.wo.intf.facade.CpsOrderSnapFacade/getCpsOrderByChannel")
                .then().log().all()
                .body("code", equalTo("200"))
                .extract().response();
    }
}
