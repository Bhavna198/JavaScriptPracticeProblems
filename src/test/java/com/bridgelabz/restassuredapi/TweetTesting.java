package com.bridgelabz.restassuredapi;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.annotations.Test;

public class TweetTesting {


    @Test
    public void postTest() {
        Response response = RestAssured.given()
                .auth()
                .oauth("TTQQO4y0DJGZLBU2LcU1VJECQ",
                        "qkf8Rj3kggsjkvc2mF5sBLvE8k93ZL9Q74nPzKujFwJ8QAofoV",
                        "4003503614-NqJnAeZ2s6oHIPEWsNJnKDoKB4TtIPD2oOFUSuW",
                        "CsW3W4jEd4OarUqbqaJSSVzy808HEAB5uyGyZDA9QrLZR")
                .post("https://api.twitter.com/1.1/statuses/update.json?status= Bhanu");

        System.out.println("status code: " + response.getStatusCode());
        System.out.println("time taken: " + response.getTime());
        response.prettyPrint();

        JsonPath jsonPath = response.jsonPath();

        String id_str = jsonPath.getString("id_str");
        System.out.println("***************");
        System.out.println(id_str);

    }

    @Test
    public void retweet() {
        Response response = RestAssured.given().auth().
                oauth("TTQQO4y0DJGZLBU2LcU1VJECQ",
                        "qkf8Rj3kggsjkvc2mF5sBLvE8k93ZL9Q74nPzKujFwJ8QAofoV",
                        "4003503614-NqJnAeZ2s6oHIPEWsNJnKDoKB4TtIPD2oOFUSuW",
                        "CsW3W4jEd4OarUqbqaJSSVzy808HEAB5uyGyZDA9QrLZR")
                .post("https://api.twitter.com/1.1/statuses/retweet/1497088794108989440.json");

        System.out.println("Response code: " + response.getStatusCode());
        System.out.println("Response jason Body: " + response.jsonPath().prettyPrint());

    }

    @Test
    public void delete() {

        Response response = RestAssured.given().auth().
                oauth("TTQQO4y0DJGZLBU2LcU1VJECQ",
                        "qkf8Rj3kggsjkvc2mF5sBLvE8k93ZL9Q74nPzKujFwJ8QAofoV",
                        "4003503614-NqJnAeZ2s6oHIPEWsNJnKDoKB4TtIPD2oOFUSuW",
                        "CsW3W4jEd4OarUqbqaJSSVzy808HEAB5uyGyZDA9QrLZR")
                .delete("https://api.twitter.com/2/tweets/1497088794108989440");

        System.out.println("Response code: " + response.getStatusCode());
        response.prettyPrint();
    }
}

