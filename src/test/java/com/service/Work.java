package com.service;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

/**
 * @Author: Richered
 * @Date: 2020/1/3 12:37
 * Description: 获取配置值；例如：token等等
 */
public class Work {

    String token;

    private static Work work;

    /**
     * 单例，可直接调用获取token
     * @return
     */
    public static Work getInstance(){
        if (work == null){
            work = new Work();
        }
        return work;
    }

    /**
     * 获取token
     * @return
     */
    public String getToken(){
        if (token == null) {
            token = given()
                            .param("corpid", "ww0fc4383ea8900ef8")
                            .param("corpsecret", "QJrWKfEXaaR72lhkwi5acMxtcDdaabylf-YyMwOAqeU")
                    .when()
                            .log().all()
                            .get("https://qyapi.weixin.qq.com/cgi-bin/gettoken")
                    .then()
                            .log().all()
                            .body("errcode", equalTo(0))
                            .extract()
                            .body().path("access_token");       //提取响应中的access_token

            System.out.println(token);
        }

        return token;
    }
}
