package com.API;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import java.util.HashMap;
import java.util.Map;

public class UsersList {
    private Map<String, Object> requestBody;
    private Response response;

    public void setUserId(String user) {
            requestBody = new HashMap<>();
            requestBody.put("id", user);
    }

    public void sendGetRequestToUserId(String userId) {
        RestAssured.baseURI = "https://dummyapi.io";
        response = RestAssured
                .given()
                .header("app-id", "63a804408eb0cb069b57e43a")
                .header("Content-Type", "application/json")
                .header("Accept", "application/json")
                .when()
                .get("/data/v1/user/" + userId); // ✅ build dynamic endpoint
    }


    public void verifyResponseStatusCode(int statusCode) {
        response.then()
                .log().all()
                .assertThat()
                .statusCode(statusCode);
    }


    public Map<String, Object> buildUserRequest(String firstName, String title) {
        Map<String, Object> body = new HashMap<>();
        body.put("firstName", firstName);
        body.put("title", title); // ✅ now title is passed from step
        body.put("lastName", "Dodi");
        body.put("picture", "https://randomuser.me/api/portraits/med/men/23.jpg");
        body.put("gender", "male");
        body.put("dateOfBirth", "1964-12-08T16:34:53.710Z");
        body.put("phone", "(886)-854-5524");

        Map<String, String> location = new HashMap<>();
        location.put("street", "Updated Street 456");
        location.put("city", "Updated City");
        location.put("state", "Updated State");
        location.put("country", "Updated Country");
        location.put("timezone", "+5:00");

        body.put("location", location);
        return body;
    }

    // ✅ POST: Create new user
    public void sendPostNewUser(Map<String, Object> requestBody) {
        RestAssured.baseURI = "https://dummyapi.io";
        response = RestAssured
                .given()
                .header("app-id", "63a804408eb0cb069b57e43a")
                .header("Content-Type", "application/json")
                .header("Accept", "application/json")
                .body(requestBody)
                .when()
                .post("/data/v1/user/create");
    }

    // ✅ PUT: Update existing user
    public void sendPutEditUser(String userId, Map<String, Object> requestBody) {
        RestAssured.baseURI = "https://dummyapi.io";
        response = RestAssured
                .given()
                .header("app-id", "63a804408eb0cb069b57e43a")
                .header("Content-Type", "application/json")
                .header("Accept", "application/json")
                .body(requestBody)
                .when()
                .put("/data/v1/user/" + userId);
    }

    public void sendDeleteUser(String userId) {
        RestAssured.baseURI = "https://dummyapi.io";
        response = RestAssured
                .given()
                .header("app-id", "63a804408eb0cb069b57e43a")
                .header("Content-Type", "application/json")
                .header("Accept", "application/json")
                .when()
                .delete("/data/v1/user/" + userId);
    }

    public String sendPostNewUserAndReturnId(Map<String, Object> requestBody) {
        RestAssured.baseURI = "https://dummyapi.io";
        response = RestAssured
                .given()
                .header("app-id", "63a804408eb0cb069b57e43a")
                .header("Content-Type", "application/json")
                .header("Accept", "application/json")
                .body(requestBody)
                .when()
                .post("/data/v1/user/create");

        return response.jsonPath().getString("id"); // ✅ extract user ID
    }

    public void verifyResponseBodyContainsId(String expectedId) {
        response.then()
                .log().body()
                .assertThat()
                .body(org.hamcrest.Matchers.equalTo(expectedId));
    }


}
