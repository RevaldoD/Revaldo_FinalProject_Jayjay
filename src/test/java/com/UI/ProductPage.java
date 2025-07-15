package com.UI;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ProductPage {
    private final WebDriver driver;

    public ProductPage(WebDriver driver) {
        this.driver = driver;
    }

    public void pauseForSeconds(int seconds) {
        new Actions(driver).pause(Duration.ofSeconds(seconds)).perform();
    }

    public void acceptAlertIfPresent() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
            wait.until(ExpectedConditions.alertIsPresent());
            driver.switchTo().alert().accept();
        } catch (Exception e) {
            System.out.println("No alert present: " + e.getMessage());
        }
    }

    // locator for the little cart badge in the header
    By laptopsSection = By.xpath("//a[contains(text(),'Laptop')]");
    By macbookAirTitle = By.xpath("//a[contains(text(), 'MacBook air')]");
    By addToCartButton = By.xpath("//a[contains(text(), 'Add to cart')]");
    By deleteButton = By.xpath("//*[@id='tbodyid']/tr/td[4]/a");
    By checkoutButton = By.xpath("//button[text()='Place Order']");
    By purchaseButton = By.xpath("//button[text()= 'Purchase']");
    By cartBadge       = By.id("cartur");
    By nameInput= By.id("name");
    By countryInput= By.id("country");
    By cityInput= By.id("city");
    By cardInput= By.id("card");
    By monthInput= By.id("month");
    By yearInput= By.id("year");
    By checkPurchaseForm= By.id("orderModalLabel");
    By clickOk = By.xpath("//button[text()='OK']");


    


    public void validateOnHomePage() {
        new WebDriverWait(driver, Duration.ofSeconds(5))
               .until(ExpectedConditions.visibilityOfElementLocated(laptopsSection));
        driver.findElement(laptopsSection).click();
        WebElement productElement = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(macbookAirTitle));
        assertEquals("MacBook air", productElement.getText());
        assertTrue(productElement.isDisplayed());
        pauseForSeconds(1);
        driver.findElement(macbookAirTitle).click();
    }

    public void clickToCart() {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(addToCartButton));
        pauseForSeconds(1);
        driver.findElement(addToCartButton).click();
    }

    public void cartList(){
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(cartBadge));
        pauseForSeconds(1);
        driver.findElement(cartBadge).click();
    }

    public void checkProductExists(){
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(deleteButton));
        pauseForSeconds(2);
    }

    public void deleteProduct(){
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(deleteButton));
        pauseForSeconds(2);
        driver.findElement(deleteButton).click();
    }

    public void checkProductDeleted(){
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.invisibilityOfElementLocated(macbookAirTitle));
    }

    public void clickPlaceOrder(){
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(checkoutButton));
        pauseForSeconds(1);
        driver.findElement(checkoutButton).click();
    }

    public void inputName(String name) {
        driver.findElement(nameInput).sendKeys(name);
    }

    public void inputCountry(String country) {
        driver.findElement(countryInput).sendKeys(country);
    }

    public void inputCity(String city) {
        driver.findElement(cityInput).sendKeys(city);
    }

    public void inputCard(String card) {
        driver.findElement(cardInput).sendKeys(card);
    }

    public void inputMonth(String month) {
        driver.findElement(monthInput).sendKeys(month);
    }

    public void inputYear(String year) {
        driver.findElement(yearInput).sendKeys(year);
    }

    public void fillOrderForm(String name, String country, String city, String card, String month, String year) {
        inputName(name);
        inputCountry(country);
        inputCity(city);
        inputCard(card);
        inputMonth(month);
        inputYear(year);
        pauseForSeconds(2);
    }


    public void checkPurchaseForm(){
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(checkPurchaseForm));
    }

    public void clickPurchaseButton(){
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(purchaseButton));
        driver.findElement(purchaseButton).click();
    }

    public void clickFinishedForm(){
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(clickOk));
        pauseForSeconds(1);
        driver.findElement(clickOk).click();
    }
}

