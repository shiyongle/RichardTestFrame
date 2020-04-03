package com.ydl.service.cps_center_service.CpsDistributorLandFacade.api;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

/**
 * @Author: Richered
 * @Date: 2020/3/30 10:43
 * Description:
 */
public class VerifyChannelId {
    public Response get(int distributorId, int channelId){
        return given()
                .queryParam("distributorId", distributorId)
                .queryParam("channelId", channelId)
                .contentType(ContentType.JSON)
                .when().log().all()
                .post("http://47.96.181.183:10088/h/com.ydl.wo.intf.facade.CpsDistributorLandFacade/verifyChannelId")
                .then().log().all()
                .body("code", equalTo("200"))
                .extract().response();
    }
}
