package com.stepdef;

import com.UI.LoginPage;
import com.additional.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class LoginStepDef extends Driver {

    private LoginPage login;

    @Given("the user is on the Login page")
    public void userIsOnLoginPage() {

        login = new LoginPage(Driver.getDriver());
        login.goToLoginPage();
    }

    @When("the user clicks the Login button with filled form")
    public void userClicksLogin() {
        login.inputUsername("ezel");
        login.inputPassword("dada");
        login.clickLoginButton();
    }

    @Then("the login is successful and redirect to dashboard without login button")
    public void userShouldSeeWelcomeMessage() {
        login.waitForWelcomeMessage();
    }

    @When("the user clicks the Login button without fill the form")
    public void voidClicksLogin() {
        login.inputUsername("");
        login.inputPassword("");
        login.clickLoginButton();
        login.acceptAlertIfPresent();
    }

    @Then("the website give error message")
    public void acceptError() {
        System.out.println("Alert was shown and handled.");
    }
}

