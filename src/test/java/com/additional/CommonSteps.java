package com.additional;

import com.page.LoginPage;

public class CommonSteps {
    public static void loginAsValidUser() {
        LoginPage loginPage = new LoginPage(Driver.getDriver());
        loginPage.goToLoginPage();
        loginPage.inputUsername("ezel");
        loginPage.inputPassword("dada");
        loginPage.clickLoginButton();
        loginPage.waitForWelcomeMessage();
    }
}
