package com.UI;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {
    private final WebDriver driver;

    By loginHome = By.xpath("//*[@id=\"login2\"]");
    By loginButton = By.xpath("//button[text()= 'Log in']");
    By usernameInputText= By.id("loginusername");
    By passwordInputText = By.id("loginpassword");
    By welcomeText = By.id("nameofuser");


    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void pauseForSeconds(int seconds) {
        new Actions(driver).pause(Duration.ofSeconds(seconds)).perform();
    }

    public void goToLoginPage() {
        driver.get("https://www.demoblaze.com/index.html");
        driver.findElement(loginHome).click();

        // ✅ Wait for the modal input to become visible
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(usernameInputText));
    }

    public void inputUsername(String username) {
        WebElement usernameField = driver.findElement(usernameInputText);
        usernameField.clear();
        usernameField.click(); // triggers browser validation
        usernameField.sendKeys(username);
    }

    public void inputPassword(String password) {
        WebElement passwordField = driver.findElement(passwordInputText);
        passwordField.clear();
        passwordField.click(); // triggers browser validation
        passwordField.sendKeys(password);
    }

    public void clickLoginButton() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Wait until login button is visible and clickable
        wait.until(ExpectedConditions.visibilityOfElementLocated(loginButton));
        wait.until(ExpectedConditions.elementToBeClickable(loginButton));

        pauseForSeconds(2); // Give modal time to fully render

        driver.findElement(loginButton).click();
    }

    public void waitForWelcomeMessage() {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(welcomeText));
    }

    public void acceptAlertIfPresent() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
            wait.until(ExpectedConditions.alertIsPresent());

            // Pause for 2 seconds before accepting the alert
            new Actions(driver).pause(Duration.ofSeconds(2)).perform();

            // ✅ Print alert text before accepting
            System.out.println("Alert Text: " + driver.switchTo().alert().getText());
            driver.switchTo().alert().accept();

        } catch (Exception e) {
            System.out.println("No alert present: " + e.getMessage());
        }
    }
}

