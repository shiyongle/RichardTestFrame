package com.restAssured;

import io.restassured.builder.ResponseBuilder;
import io.restassured.filter.Filter;
import io.restassured.filter.FilterContext;
import io.restassured.response.Response;
import io.restassured.specification.FilterableRequestSpecification;
import io.restassured.specification.FilterableResponseSpecification;

/**
 * @Author: Richered
 * @Date: 2020/1/30 15:44
 * @Description: 修改响应状态码
 */
public class FilterDemo implements Filter {
    @Override
    public Response filter(FilterableRequestSpecification requestSpec, FilterableResponseSpecification responseSpec, FilterContext ctx) {
        Response responseOrigin = ctx.next(requestSpec, responseSpec);
        return new ResponseBuilder().clone(responseOrigin).setStatusCode(404).build();
    }
}
