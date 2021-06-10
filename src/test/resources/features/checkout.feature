
Feature: Checkout

  I want to be able to buy some product

  Scenario: Successful checkout
    Given User on shop home page
    When he selects product
    And he fills address details
    Then he should be redirected to thank you page