package com.restAssured;

import io.restassured.http.ContentType;
import org.junit.Test;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;

import static io.restassured.RestAssured.*;
import static io.restassured.path.json.JsonPath.from;
import static org.hamcrest.CoreMatchers.hasItems;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class LocalInterface {
    @Test
    public void testlocal(){
        useRelaxedHTTPSValidation();
        proxy("127.0.0.1",8000);
        given()
                .queryParam("username","Richered")
                .header("Cookie","Custom Cookie")
//                .formParam("username","Richered")
        .when()
                .post("http://localhost:8000/CGIProject/cgi-bin/")
        .then()
                .statusCode(200);
    }

    @Test
    public void testPostJson(){
        HashMap<String , Object> map = new HashMap<String ,Object>();
        map.put("username","admin");
        map.put("password","admin");
        map.put("capcha","n6d58");

        given().log().all()
                .contentType(ContentType.JSON)
                .body(map)

                .when()
                .post("http://localhost:8080/renren-fast/sys/login")

                .then()
                .statusCode(200);
    }

    @Test
    public void TestAssertion(){
        given()
                .contentType(ContentType.JSON)
                .when()
                .get("http://localhost:8000/CGIProject/cgi-bin/store.json")
                .then()
                .log().all()
                .body("store.book.findAll { it.price < 10 }.title",hasItems("Sayings of the Century", "Moby Dick"))
                .body("store.book.author.collect { it.length() }.sum()", greaterThan(50));

    }

    @Test
    public void ResponseDate(){
        InputStream stream = get("http://localhost:8000/CGIProject/cgi-bin/store.json").asInputStream();
        byte[] byteArray = get("http://localhost:8000/CGIProject/cgi-bin/store.json").asByteArray();
        String json = get("http://localhost:8000/CGIProject/cgi-bin/store.json").asString();
        System.out.println(json);
    }

    String response = get("http://localhost:8000/CGIProject/cgi-bin/store.json").asString();
    List<String> bookTitles = from(response).getList("store.book.findAll { it.price < 10 }.title");
    int sumOfAllAuthorLengths = from(response).getInt("store.book.author*.length().sum");

    @Test
    public void JsonPathDemo(){
        System.out.println(bookTitles);
        assertThat(sumOfAllAuthorLengths, is(53));
    }
}
