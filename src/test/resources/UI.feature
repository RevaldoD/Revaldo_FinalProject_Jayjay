@ui
Feature: Demoblaze website

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

  @valid-login
  Scenario: Able to login with valid username and password
    Given the user is on the Login page
    When the user clicks the Login button with filled form
    Then the login is successful and redirect to dashboard without login button

  @invalid-login
  Scenario: Unable to login without username and password
    Given the user is on the Login page
    When the user clicks the Login button without fill the form
    Then the website give error message