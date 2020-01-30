package com.restAssured;

import io.restassured.builder.ResponseBuilder;
import io.restassured.filter.Filter;
import io.restassured.filter.FilterContext;
import io.restassured.response.Response;
import io.restassured.specification.FilterableRequestSpecification;
import io.restassured.specification.FilterableResponseSpecification;

import java.util.Base64;

/**
 * @Author: Richered
 * @Date: 2020/1/30 15:57
 * @Description: Base64解密
 */
public class Base64Filter implements Filter {
    @Override
    public Response filter(FilterableRequestSpecification requestSpec, FilterableResponseSpecification responseSpec, FilterContext ctx) {
        Response responseOrigin = ctx.next(requestSpec, responseSpec);
        ResponseBuilder responseBuilder = new ResponseBuilder().clone(responseOrigin);
        String tmpDecodeContent = new String(Base64.getDecoder().decode(responseOrigin.body().asString().trim()));
        responseBuilder.setBody(tmpDecodeContent);
        Response resNew = responseBuilder.build();
        return resNew;
    }
}
