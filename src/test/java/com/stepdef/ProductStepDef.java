package com.stepdef;

import com.additional.CommonSteps;
import com.additional.Driver;
import com.UI.LoginPage;
import com.UI.ProductPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;


public class ProductStepDef extends Driver{
    private ProductPage product;

    // Positive Product test steps
    @Given("the user is on the Products page")
    public void userIsOnProductsPage(){
        new LoginPage(Driver.getDriver());
        CommonSteps.loginAsValidUser();

        product = new ProductPage(Driver.getDriver());
        product.validateOnHomePage();
    }

    @When("the user clicks the Add to cart button for a product")
    public void userClicksAddToCart(){
        product.clickToCart();
    }

    @And("the user navigates to the cart page")
    public void pressCartIcon(){
        product.acceptAlertIfPresent();
        product.cartList();
    }

    @Then("the product should appear in the cart")
    public void productShouldAppearInCart(){
        product.checkProductExists();
    }

    @And("the user clicks delete button")
    public void pressDeleteButton(){
        product.deleteProduct();
    }

    @Then("the product is deleted from the cart")
    public void producDeleted(){
        product.checkProductDeleted();
    }

    @And("the user clicks Checkout")
    public void pressCheckout(){
        product.checkProductExists();
        product.clickPlaceOrder();
        product.checkPurchaseForm();
    }

    @And("Fill the form")
    public void fillTheForm() {
        product.fillOrderForm("Valdo", "Indonesia", "Jakarta", "987654321123", "July", "2025");
        product.checkPurchaseForm();
    }

    @Then("the user succeed checkout the products")
    public void pressPurchase(){
        product.clickPurchaseButton();
        product.clickFinishedForm();
    }
}
