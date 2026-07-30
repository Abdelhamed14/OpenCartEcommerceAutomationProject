@regression @search
Feature: Product Search

  Scenario: Search for an existing product
    Given the user is on the OpenCart home page
    When the user searches for the product "MacBook"
    Then the search results should display "MacBook"

  Scenario: Search for a non-existing product
    Given the user is on the OpenCart home page
    When the user searches for the product "NonExistingProduct12345"
    Then a no products found message should be displayed