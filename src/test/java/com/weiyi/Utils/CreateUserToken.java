package com.weiyi.Utils;

import io.restassured.http.ContentType;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

/**
 * @Author: Richered
 * @Date: 2022/2/18 15:33
 * @Description
 */
public class CreateUserToken extends Common{

    private static String TOKEN;

    private static String LOGINID = "13210001000";

    private static String PASSWORD = "ff9f9df160141abb39fa9676284c1433";

    private static CreateUserToken createUserToken;

    public static CreateUserToken getInstance(){
        if(createUserToken == null){
            createUserToken = new CreateUserToken();
        }
        return createUserToken;
    }

    public String getToken(){
        Map<String, Object> data = new HashMap<>();
        data.put("loginId",LOGINID);
        data.put("password",PASSWORD);
        if (TOKEN == null){
            TOKEN = given()
                        .header("weiyi-appid", APP_ID)
                        .contentType(ContentType.JSON)
                        .body(data)
                    .when()
                        .log().all()
                        .post(URL + "/user/account/login.json")
                    .then()
                        .log().all()
                        .extract()
                        .body().path("authentication");
            System.out.println(TOKEN);
        }
        return TOKEN;
    }
}
