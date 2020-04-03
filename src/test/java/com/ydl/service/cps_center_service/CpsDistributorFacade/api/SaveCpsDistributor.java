package com.ydl.service.cps_center_service.CpsDistributorFacade.api;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

/**
 * @Author: Richered
 * @Date: 2020/3/30 10:13
 * Description: dubbo报文加密
 */
public class SaveCpsDistributor {
//    {
//        "distributorId": 118,
//            "name": "SpringBoot升级",
//            "phone": "13000210023",
//            "bankId": 1,
//            "bankAddress": "杭州分行",
//            "bankProvince": "浙江",
//            "bankCity": "杭州",
//            "cardId": "622222222222222222",
//            "cardHolder": "涨停",
//            "contracts": "hangzhou.aliyuncs.com/FmtaFEXdjf.jpg",
//            "cpsStatus": 1,
//            "account": "SpringBoot升级",
//            "accountPassword": "s19951226",
//            "financeAccountId": 0,
//            "userId": 130950951,
//            "creator": "admin",
//            "modifier": "admin"
//    }
public Response get(int distributorId){
        return given()
                .queryParam("distributorId", distributorId)
                .contentType(ContentType.JSON)
                .when().log().all()
                .post("http://47.96.181.183:10088/h/com.ydl.wo.intf.facade.CpsDistributorFacade/saveCpsDistributor")
                .then().log().all()
                .body("code", equalTo("200"))
                .extract().response();
    }
}
