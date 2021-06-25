
Feature: Log in user

  Log in user feature tests for selenium demo app.

  Scenario: Log in user
    Given User with email "test1@test.pl" which already exist in the application
    When User logs in to the application
    Then User should be redirected to logged user page
