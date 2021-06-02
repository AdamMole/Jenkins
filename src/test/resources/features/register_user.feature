
Feature: Register user

  Register user feature tests for selenium demo app.
  Description will be ignored and will not affect test execution

  Scenario: Register user with unique email
    Given User with unique email
    When User registers in application
    Then User should be redirected to logged user page

  Scenario: Register user with email which already exist in the application
    Given User with email which already exist in the application
    When User registers in application
    Then User should see an error which contains An account is already registered with your email address