@login
Feature: Login

  @valid-login
  Scenario: Able to login with valid username and password
    Given the user is on the Login page
    When the user clicks the Login button with filled form
    Then the login is successful and redirect to dashboard without login button
