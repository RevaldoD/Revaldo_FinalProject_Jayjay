@product
Feature: Products

  @valid-addtocart
  Scenario: Add product to cart
    Given the user is on the Products page
    When the user clicks the Add to cart button for a product
    And the user navigates to the cart page
    Then the product should appear in the cart

  @valid-deleteProductCart
  Scenario: Delete a product on cart page
    Given the user is on the Products page
    When the user clicks the Add to cart button for a product
    And the user navigates to the cart page
    And the user clicks delete button
    Then the product is deleted from the cart

  @valid-endToEndCheckoutProduct
  Scenario: Checkout Product
    Given the user is on the Products page
    When the user clicks the Add to cart button for a product
    And the user navigates to the cart page
    And the user clicks Checkout
    And Fill the form
    Then the user succeed checkout the products