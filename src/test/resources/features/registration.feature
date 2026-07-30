@regression @registration
Feature: User Registration

  Scenario: Register a new account with valid data
    Given the user navigates to the registration page
    When the user enters valid registration details
    And the user agrees to the privacy policy
    And the user submits the registration form
    Then the account should be created successfully