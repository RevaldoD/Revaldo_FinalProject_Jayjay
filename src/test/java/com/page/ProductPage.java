package com.page;

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

    // locator for the little cart badge in the header
    By laptopsSection = By.xpath("//a[contains(text(),'Laptop')]");
    By macbookAirTitle = By.xpath("//a[contains(text(), 'MacBook air')]");
    By addToCartButton = By.xpath("//a[contains(text(), 'Add to cart')]");
    By deleteButton = By.xpath("//a[contains(text(), 'Delete')]");
    By cartBadge       = By.id("cartur");

    


    public void validateOnHomePage() {
        new WebDriverWait(driver, Duration.ofSeconds(5))
               .until(ExpectedConditions.visibilityOfElementLocated(laptopsSection));
        driver.findElement(laptopsSection).click();
        WebElement productElement = new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(macbookAirTitle));
        assertTrue(productElement.isDisplayed());
        assertEquals("MacBook air", productElement.getText());
        driver.findElement(macbookAirTitle).click();
    }

    public void clickToCart() {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(addToCartButton));
        driver.findElement(addToCartButton).click();
    }

    public void cartList(){
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(cartBadge));
        driver.findElement(cartBadge).click();
    }

    public void checkProductExists(){
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(deleteButton));
    }

    public void deleteProduct(){
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(deleteButton));
        driver.findElement(deleteButton).click();
        new Actions(driver).pause(Duration.ofSeconds(5)).perform();
    }

    public void checkProductDeleted(){
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.invisibilityOfElementLocated(macbookAirTitle));
    }
}

