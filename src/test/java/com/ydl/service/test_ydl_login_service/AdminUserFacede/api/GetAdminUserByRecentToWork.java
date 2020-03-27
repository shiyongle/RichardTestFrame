package com.ydl.service.test_ydl_login_service.AdminUserFacede.api;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

/**
 * @Author: Richered
 * @Date: 2020/3/27 15:49
 * Description: 获取值班时间最近的管理员
 */
public class GetAdminUserByRecentToWork {
    public Response getByRecentName(){
        return given()
                .when().log().all()
                .post("http://47.97.49.44:9092/h/com.ydl.login.intf.facade.AdminUserFacade/getAdminUserByRecentToWork")
                .then().log().all()
                .body("code", equalTo("200"))
                .extract().response();
    }
}
