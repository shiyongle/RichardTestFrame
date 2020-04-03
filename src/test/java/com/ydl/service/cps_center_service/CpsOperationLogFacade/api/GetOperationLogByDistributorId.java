package com.ydl.service.cps_center_service.CpsOperationLogFacade.api;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

/**
 * @Author: Richered
 * @Date: 2020/3/30 10:45
 * Description:
 */
public class GetOperationLogByDistributorId {
    public Response get(int distributorId){
        return given()
                .queryParam("distributorId", distributorId)
                .contentType(ContentType.JSON)
                .when().log().all()
                .post("http://47.96.181.183:10088/h/com.ydl.wo.intf.facade.CpsOperationLogFacade/getOperationLogByDistributorId")
                .then().log().all()
                .body("code", equalTo("200"))
                .extract().response();
    }
}
