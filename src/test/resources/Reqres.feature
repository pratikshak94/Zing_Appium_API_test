Feature: Test user request and response for Reqres API

  @SmokeTest
  Scenario Outline: Reqres GET API test
    Given As an end user, I want to retrieve the list of users
    When I send the request with page number as “<page>”
    Then I should be able to validate the response successfully

    Examples:
      | page | emailID                  |
      | 2    | pratiksha.kale@reqres.in |
      | 1    | pratima.kale@reqres.in   |


  @SmokeTest
  Scenario Outline: Reqres POST API test

    Given As an end user, I want to add new set of user details
    When the request is send to the server
    Then the new user must be created with name as “<username>” , "<job>", "<emailID>"

    Examples:
      | username | job               |  | emailID          |
      | yogesh   | software engineer |  | yogi12@gmail.com |
