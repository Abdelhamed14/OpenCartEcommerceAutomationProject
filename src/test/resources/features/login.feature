@regression @login
Feature: User Login

  Scenario: Login with valid credentials
    Given a new user account has been created
    And the user logs out of the account
    When the user logs in using the newly registered credentials
    Then the user should be redirected to the account page

  Scenario Outline: Login with invalid credentials
    Given the user navigates to the login page
    When the user logs in with email "<email>" and password "<password>"
    Then a login warning message should be displayed

    Examples:
      | email                    | password      |
      | invalid_user@example.com | Invalid@123   |
      | test_user@example.com    | WrongPassword |
      | invalid_email_format     | Test@12345    |