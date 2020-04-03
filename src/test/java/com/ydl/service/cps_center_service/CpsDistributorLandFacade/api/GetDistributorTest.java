package com.ydl.service.cps_center_service.CpsDistributorLandFacade.api;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

/**
 * @Author: Richered
 * @Date: 2020/3/30 10:35
 * Description:
 */
public class GetDistributorTest {
    public Response get(int distributorId, int productType, int channelId){
        return given()
                .queryParam("distributorId", distributorId)
                .queryParam("productTypeId", productType)
                .queryParam("channelId", channelId)
                .contentType(ContentType.JSON)
                .when().log().all()
                .post("http://47.96.181.183:10088/h/com.ydl.wo.intf.facade.CpsDistributorLandFacade/getDistributorTest")
                .then().log().all()
                .body("code", equalTo("200"))
                .extract().response();
    }
}
