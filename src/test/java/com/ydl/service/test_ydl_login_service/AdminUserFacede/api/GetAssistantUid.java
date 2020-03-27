package com.ydl.service.test_ydl_login_service.AdminUserFacede.api;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

/**
 * @Author: Richered
 * @Date: 2020/3/27 15:53
 * Description: 获取绑定了助理的助理uid三参
 */
public class GetAssistantUid {
    public Response get(boolean needOnline, byte assistantType, boolean filterBindDoctorAssistant){
        return given()
                .queryParam("needOnline", needOnline)
                .queryParam("assistantType", assistantType)
                .queryParam("filterBindDoctorAssistant", filterBindDoctorAssistant)
                .contentType(ContentType.JSON)
                .when().log().all()
                .post("http://47.97.49.44:9092/h/com.ydl.login.intf.facade.AdminUserFacade/getAssistantUid")
                .then().log().all()
                .body("code", equalTo("200"))
                .extract().response();
    }
}
