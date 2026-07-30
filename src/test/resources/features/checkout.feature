@regression @checkout
Feature: Checkout

  Scenario: Proceed to checkout with an available product
    Given the user is on the OpenCart home page
    When the user searches for the product "HP LP3065"
    And the user opens the product "HP LP3065"
    And the user adds the product to the cart from the product page
    And the user opens the shopping cart page
    And the user proceeds to checkout
    Then the checkout page should be displayed