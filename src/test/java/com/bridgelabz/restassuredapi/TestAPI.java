package com.bridgelabz.restassuredapi;

import io.restassured.RestAssured;
import io.restassured.internal.path.json.mapping.JsonObjectDeserializer;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

public class TestAPI {

    @Test
    public void getTest(){
        Response response= RestAssured.get("http://localhost:3000/posts");
        System.out.println("Response code: " + response.getStatusCode());
        response.prettyPrint();
    }
    @Test
    public void postTest(){
        RequestSpecification requestSpecification= RestAssured.given();
        requestSpecification.header("Content-Type", "application/json");
        JSONObject jsonObject=new JSONObject();
        jsonObject.put("id", 10);
        jsonObject.put("title", "Bhavna");
        jsonObject.put("author", "TestAPI");
        requestSpecification.body(jsonObject.toJSONString());
        Response response = requestSpecification.post("http://localhost:3000/posts");
        System.out.println("responseCode: " +response.getStatusCode());
        response.prettyPrint();
    }
    @Test
    public void putTest() {
        RequestSpecification requestSpecification = RestAssured.given();
        requestSpecification.header("Content-Type", "application/json");
        JSONObject jsonObject = new JSONObject();
        //jsonObject.put("id", 3);
        jsonObject.put("title", "Bhanu");
        jsonObject.put("author", "RestAPI");
        requestSpecification.body(jsonObject.toJSONString());
        Response response = requestSpecification.put("http://localhost:3000/posts/10");
        System.out.println("responseCode: " + response.getStatusCode());
        response.prettyPrint();
    }
    @Test
    public void deleteTest() {
        RequestSpecification requestSpecification = RestAssured.given();
        requestSpecification.header("Content-Type", "application/json");
        Response response = requestSpecification.delete("http://localhost:3000/posts/10");
        System.out.println("responseCode: " + response.getStatusCode());
        response.prettyPrint();

    }
}
