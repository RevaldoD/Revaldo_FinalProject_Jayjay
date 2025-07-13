@api
Feature: API test

  @retrieve-user
  Scenario: Retrieve specific user full biodata
    Given the user id want to retrieve is "60d0fe4f5311236168a109d7"
    When the user sends a GET request to retrieve that user
    Then the response status code should be 200

  @create-user
  Scenario: Create new valid user
    Given input user data with the designated format
    When the user sends a POST request to create new user
    Then the response status code should be 200

  @update-user
  Scenario: Update existing user
    Given the user id want to retrieve is "60d0fe4f5311236168a109d7"
    When the user sends PUT request to update user data with name "Rose" and title "ms"
    Then the response status code should be 200

  @delete-created-user
  Scenario: Delete a user right after creating them
    Given a valid new user is created
    When the user sends a DELETE request for the created user
    Then the response status code should be 200
    And the response body should contain the deleted user ID

  @create-hollow-user
  Scenario: Create new user without the body
    Given input user data with some of the data blank
    When the user sends a POST request to create new user
    Then the response status code should be 400

