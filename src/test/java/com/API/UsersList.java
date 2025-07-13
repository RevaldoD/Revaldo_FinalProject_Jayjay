package com.API;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.CoreMatchers.equalTo;

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
                .get("/data/v1/user/" + userId);
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
        body.put("title", title);
        body.put("lastName", "Savela");
        body.put("picture", "https://randomuser.me/api/portraits/med/men/67.jpg");
        body.put("gender", "male");

        String uniqueEmail = "leevi" + System.currentTimeMillis() + "@example.com";
        body.put("email", uniqueEmail);

        body.put("dateOfBirth", "1980-12-19T12:11:14.893Z");
        body.put("phone", "02-200-101");

        Map<String, String> location = new HashMap<>();
        location.put("street", "4013, HÃ¤meentie");
        location.put("city", "Malax");
        location.put("state", "Southern Ostrobothnia");
        location.put("country", "Finland");
        location.put("timezone", "+1:00");

        body.put("location", location);
        return body;
    }

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


    public void sendPutEditUser(String userId, Map<String, Object> requestBody) {
        requestBody.remove("email");

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

        return response.jsonPath().getString("id");
    }


    public void verifyResponseBodyContainsId(String expectedId) {
        if (response != null) {
            response.then()
                    .log().body()
                    .body("id", equalTo(expectedId));
        } else {
            throw new IllegalStateException("No response to verify.");
        }
    }

}
