@regression @cart
Feature: Shopping Cart

  Scenario: Add an available product to the shopping cart
    Given the user is on the OpenCart home page
    When the user searches for the product "MacBook"
    And the user adds "MacBook" to the shopping cart
    Then an add to cart success message should be displayed for "MacBook"
    And the shopping cart should contain "1 item(s)"

  Scenario: Remove a product from the shopping cart
    Given the user is on the OpenCart home page
    When the user searches for the product "MacBook"
    And the user adds "MacBook" to the shopping cart
    And the user opens the shopping cart page
    Then "MacBook" should be displayed in the shopping cart
    When the user removes "MacBook" from the shopping cart
    Then the shopping cart should be empty