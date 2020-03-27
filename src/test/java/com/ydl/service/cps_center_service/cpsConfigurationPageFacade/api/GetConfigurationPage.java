package com.ydl.service.cps_center_service.cpsConfigurationPageFacade.api;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

/**
 * @Author: Richered
 * @Date: 2020/3/27 17:18
 * Description:
 */
public class GetConfigurationPage {
    public Response get(int distributorId, int channelId, int productType){
        return given()
                .queryParam("distributorId", distributorId)
                .queryParam("channelId", channelId)
                .queryParam("productType", productType)
                .contentType(ContentType.JSON)
                .when().log().all()
                .post("http://47.96.181.183:10088/h/com.ydl.wo.intf.facade.CpsConfigurationPageFacade/getConfigurationPage")
                .then().log().all()
                .body("code", equalTo("200"))
                .extract().response();
    }
}
