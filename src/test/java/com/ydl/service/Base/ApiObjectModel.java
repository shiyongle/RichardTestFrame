package com.ydl.service.Base;

import io.restassured.response.Response;

import java.util.HashMap;

/**
 * @Author: Richered
 * @Date: 2020/1/13 21:44
 * @Description:
 */
public class ApiObjectModel {
    public HashMap<String, ApiObjectMethodModel> methods = new HashMap<>();

    public ApiObjectMethodModel getMethod(String method){
        return methods.get(method);
    }

    public Response run(String method){
        return getMethod(method).run();
    }

    public Response run(String method, HashMap<String, Object> params) {
        return getMethod(method).run(params);
    }
}
