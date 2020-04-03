package com.ydl.service.Base;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

/**
 * @Author: Richered
 * @Date: 2020/1/13 21:46
 * @Description: 方法定义
 */
public class ApiObjectMethodModel {
    private HashMap<String, Object> params;
    public HashMap<String, Object> query;
    public HashMap<String, Object> header;
    public HashMap<String, Object> postBody;
    public String postBodyRaw;
    public String method = "get";
    public String url = "";

    public Response run(){
        RequestSpecification request = given();

        if (query != null){
            query.entrySet().forEach(entry->{
                request.queryParam(entry.getKey(), repalce(entry.getValue().toString()));
            });
        }
        if (header != null){
            query.entrySet().forEach(entry->{
                request.header(entry.getKey(), repalce(entry.getValue().toString()));
            });
        }
        if (postBody != null){
            request.body(postBody);
        }
        if (postBodyRaw != null){
            request.body(repalce(postBodyRaw));
        }
        return request
                .when().log().all().request(method, url)
                .then().log().all().extract().response();
    }

    public String repalce(String raw){
        for (Map.Entry<String, Object> kv : params.entrySet()) {
            String matcher = "${" + kv.getKey() + "}";
            if (raw.contains(matcher)) {
                System.out.println(kv);
                raw = raw.replace(matcher, kv.getValue().toString());
            }
        }
        return raw;
    }

    public Response run(HashMap<String, Object> params) {
        this.params=params;
        return run();
    }
}
