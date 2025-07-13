package com.stepdef;

import com.API.UsersList;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.Map;

public class UserStepDef {
    private UsersList user = new UsersList();
    private Map<String, Object> requestBody;
    private String userId;
    private String createdUserId;

    @Given("the user id want to retrieve is {string}")
    public void saveUserId(String id) {
        this.userId = id; // save for later use
    }

    @When("the user sends a GET request to retrieve that user")
    public void sendGetRequest() {
        user.sendGetRequestToUserId(userId);
    }

    @Then("the response status code should be {int}")
    public void verifyStatusCode(int statusCode) {
        user.verifyResponseStatusCode(statusCode);
    }

    @Given("input user data with the designated format")
    public void inputUserData() {
        requestBody = user.buildUserRequest("tidi", "mr"); // ✅ calls reusable method from UsersList
    }

    @When("the user sends a POST request to create new user")
    public void sendCreateUserRequest() {
        user.sendPostNewUser(requestBody);
    }

    @When("the user sends PUT request to update user data with name {string} and title {string}")
    public void sendPutUpdateWithNameAndTitle(String firstName, String title) {
        requestBody = user.buildUserRequest(firstName, title);
        user.sendPutEditUser(userId, requestBody);
    }

    @Given("a valid new user is created")
    public void createNewUser() {
        Map<String, Object> userBody = user.buildUserRequest("PipelineUser", "mr");
        createdUserId = user.sendPostNewUserAndReturnId(userBody); // ✅ safely stores ID
    }

    @When("the user sends a DELETE request for the created user")
    public void deleteCreatedUser() {
        user.sendDeleteUser(createdUserId);
    }

    @And("the response body should contain the deleted user ID")
    public void checkResponseBodyContainsDeletedId() {
        user.verifyResponseBodyContainsId(createdUserId);
    }

    @Given("input user data with some of the data blank")
    public void inputBlankData() {
        requestBody = user.buildUserRequest("", ""); // ✅ calls reusable method from UsersList
    }
}
