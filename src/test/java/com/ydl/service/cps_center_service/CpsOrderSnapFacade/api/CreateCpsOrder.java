package com.ydl.service.cps_center_service.CpsOrderSnapFacade.api;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

/**
 * @Author: Richered
 * @Date: 2020/3/30 13:40
 * Description:
 */
public class CreateCpsOrder {
//    {
//        "id": 24458,
//            "cpsDistributorId": 112,
//            "orderType": 4,
//            "orderId": 94200313002058,
//            "isFirst": 1,
//            "orderPrice": 0.1,
//            "orderPaidPrice": 0.1,
//            "payTime": "2020-03-27T08:42:27.440Z",
//            "fristTime": "2020-03-27T08:42:27.440Z",
//            "uid": 0,
//            "isNewUser": 0,
//            "channelId": 107
//    }

    public Response get(int distributorId){
        return given()
                .queryParam("distributorId", distributorId)
                .contentType(ContentType.JSON)
                .when().log().all()
                .post("http://47.96.181.183:10088/h/com.ydl.wo.intf.facade.CpsOrderSnapFacade/createCpsOrder")
                .then().log().all()
                .body("code", equalTo("200"))
                .extract().response();
    }
}
